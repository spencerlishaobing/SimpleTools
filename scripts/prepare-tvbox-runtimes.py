"""Reproducible Python runtime and Java/DEX loader preparation for desktop packaging."""
import hashlib
import pathlib
import shutil
import subprocess
import sys
import urllib.request
import zipfile

root=pathlib.Path(__file__).resolve().parents[1]
resources=root/'src-tauri/resources'
python=resources/'python'
archive=root/'runtime/python-runtime.zip'
digest='e0780912ee37496035bfc81120cc18a0d93921842012d5e83a71b42110452965'
if not (python/'python.exe').exists():
    if not archive.exists():urllib.request.urlretrieve('https://www.python.org/ftp/python/3.13.10/python-3.13.10-embed-amd64.zip',archive)
    if hashlib.sha256(archive.read_bytes()).hexdigest()!=digest:raise RuntimeError('Python archive hash mismatch')
    with zipfile.ZipFile(archive) as z:z.extractall(python)
(python/'python313._pth').write_text('python313.zip\n.\nLib/site-packages\n../tvpython\nimport site\n')
if not (python/'Lib/site-packages/requests').exists():
    if sys.version_info[:2]!=(3,13):raise RuntimeError('Build dependencies need Python 3.13 (runtime users do not need Python installed)')
    subprocess.run([sys.executable,'-m','pip','install','--target',python/'Lib/site-packages','-r',root/'runtime/python/requirements.txt'],check=True)
shutil.copytree(root/'runtime/python',resources/'tvpython',dirs_exist_ok=True,ignore=shutil.ignore_patterns('__pycache__'))
# copy_fantaiying 分支：不准备 JAR/JVM 资源（不解析 JAR，包更小）
# subprocess.run([sys.executable,root/'scripts/build-tvbox-java.py'],check=True)
subprocess.run([python/'python.exe','-c','import requests,lxml,Crypto,bs4,pyquery,jsonpath,ujson,cachetools'],check=True)
print('TVBox Python and Java/DEX loader resources prepared.')
