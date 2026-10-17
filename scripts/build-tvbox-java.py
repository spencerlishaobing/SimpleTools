"""Package a private OpenJDK JRE, dex2jar and the desktop Spider host."""
import hashlib
import json
import os
import pathlib
import shutil
import subprocess
import urllib.request
import zipfile

root=pathlib.Path(__file__).resolve().parents[1]
source=root/'runtime/java'
build=source/'build';build.mkdir(exist_ok=True)
target=root/'src-tauri/resources/java';target.mkdir(parents=True,exist_ok=True)
metadata=json.loads((source/'jre.json').read_text(encoding='utf-8-sig'))
archive=source/'jre.zip'
if not archive.exists():urllib.request.urlretrieve(metadata['url'],archive)
if hashlib.sha256(archive.read_bytes()).hexdigest()!=metadata['sha256']:raise RuntimeError('JRE archive SHA256 mismatch')
if not (target/'jre/bin/java.exe').exists():
    with zipfile.ZipFile(archive) as z:
        prefix=z.namelist()[0].split('/')[0]+'/'
        for item in z.infolist():
            if item.is_dir():continue
            relative=pathlib.PurePosixPath(item.filename.removeprefix(prefix))
            if relative.is_absolute() or '..' in relative.parts:raise RuntimeError('Invalid archive entry')
            output=target/'jre'/relative;output.parent.mkdir(parents=True,exist_ok=True);output.write_bytes(z.read(item))
archive=source/'dex-tools.zip'
if not archive.exists():urllib.request.urlretrieve('https://github.com/pxb1988/dex2jar/releases/download/v2.4/dex-tools-v2.4.zip',archive)
if hashlib.sha256(archive.read_bytes()).hexdigest()!='ee7c45eb3c1d2474a6145d8d447e651a736a22d9664b6d3d3be5a5a817dda23a':raise RuntimeError('dex2jar SHA256 mismatch')
with zipfile.ZipFile(archive) as z:
    for name in z.namelist():
        if name.endswith('/') or '/lib/' not in name and not name.lower().endswith(('notice.txt','license.txt')):continue
        output=target/'dex'/pathlib.PurePosixPath(name).name;output.parent.mkdir(parents=True,exist_ok=True);output.write_bytes(z.read(name))
        filename=pathlib.PurePosixPath(name).name
        if filename.startswith(('dex-','d2j-base-cmd-','asm-')) or filename.lower().endswith(('license.txt','notice.txt')):
            runtime_output=target/'dex-runtime'/filename;runtime_output.parent.mkdir(exist_ok=True);runtime_output.write_bytes(z.read(name))
deps={
 'okhttp':'com/squareup/okhttp3/okhttp/3.12.13/okhttp-3.12.13.jar',
 'okio':'com/squareup/okio/okio/1.17.5/okio-1.17.5.jar',
 'gson':'com/google/code/gson/gson/2.10.1/gson-2.10.1.jar',
 'jsoup':'org/jsoup/jsoup/1.16.1/jsoup-1.16.1.jar',
 # Android 兼容 org.json（AOSP 2013 移植）：getString/getInt 等对类型宽松（JSON-java 新版会抛异常），
 # TVBox 系 JAR 按 Android org.json 行为编写，必须用 Android 版
 'json':'com/vaadin/external/google/android-json/0.0.20131108.vaadin1/android-json-0.0.20131108.vaadin1.jar',
}
manifest_file=source/'dependencies.json'
manifest=json.loads(manifest_file.read_text()) if manifest_file.exists() else {}
for name,path in deps.items():
    output=target/'lib'/(name+'.jar');output.parent.mkdir(exist_ok=True)
    url='https://repo.maven.apache.org/maven2/'+path
    if not output.exists():urllib.request.urlretrieve(url,output)
    digest=hashlib.sha256(output.read_bytes()).hexdigest()
    if name in manifest and manifest[name]['sha256']!=digest:raise RuntimeError('Dependency checksum mismatch: '+name)
    manifest[name]={'url':url,'sha256':digest}
manifest_file.write_text(json.dumps(manifest,indent=2))
classes=build/'classes';classes.mkdir(exist_ok=True)
sources=list((source/'src').rglob('*.java'))
subprocess.run(['javac','-encoding','UTF-8','--release','8','-classpath',str(target/'lib/*'),'-d',str(classes),*map(str,sources)],check=True)
subprocess.run(['jar','cf',str(target/'host.jar'),'-C',str(classes),'.'],check=True)
shutil.copy(source/'jre.json',target/'jre-provenance.json')
shutil.copy(manifest_file,target/'dependencies.json')
print('Prepared built-in JRE and Java/DEX Spider loader:',target)
