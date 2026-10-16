"""Real embedded Python and JVM class/DEX integration, no mocked runtime."""
import base64
import hashlib
import json
import os
import pathlib
import subprocess
import urllib.request
import urllib.error
import zipfile

root=pathlib.Path(__file__).resolve().parents[1]
def request(url,data=None,token='test-secret'):
    req=urllib.request.Request(url,json.dumps(data).encode() if data is not None else None,headers={'X-TVBOX-Token':token,'Content-Type':'application/json'})
    with urllib.request.urlopen(req,timeout=30) as response:return response.read()
def verify(origin,data,token):
    def call(action,args={}):return json.loads(request(origin+'/call',{**data,'action':action,'args':args},token))
    assert call('home')['list'][0]['vod_id']=='1'
    assert call('category',{'t':'1','page':2,'filters':{'year':'2026'}})['list']
    assert call('search',{'keyword':'测试搜索','page':2})['list'][0]['vod_name']=='测试搜索'
    assert call('detail',{'id':'1'})['list'][0]['vod_play_url']=='第一集$test-id'
    video=call('play',{'id':'test-id','flag':'测试','flags':[]})
    assert video['header']['X-Extend']=='custom-extension'
    return video

def python_test():
    cache=root/'runtime/java/build/python-test';cache.mkdir(parents=True,exist_ok=True)
    child=subprocess.Popen([root/'src-tauri/resources/python/python.exe',root/'src-tauri/resources/tvpython/worker.py','--token','test-secret'],cwd=cache,stdout=subprocess.PIPE,stderr=subprocess.PIPE,text=True)
    try:
        origin='http://127.0.0.1:'+str(json.loads(child.stdout.readline())['port'])
        data={'api':'https://fixture.test/spider.py','key':'fixture','ext':'custom-extension','source':(root/'tests/fixtures/tvbox_spider.py').read_text(encoding='utf-8')}
        video=verify(origin,data,'test-secret');assert request(video['url'])==b'Python proxy ok';assert video['calls']==1
        try:request(origin+'/health',token='wrong');raise AssertionError('Unauthorized access allowed')
        except urllib.error.HTTPError as e:assert e.code==403
        print('PASS: embedded Python dependencies, home/category/search/detail/play, persistent instance and local media proxy')
    finally:child.terminate();child.wait(timeout=10)

def java_test():
    build=root/'runtime/java/build';classes=build/'fixture-classes';classes.mkdir(parents=True,exist_ok=True)
    runtime=root/'src-tauri/resources/java'
    subprocess.run(['javac','-encoding','UTF-8','--release','8','-classpath',str(runtime/'host.jar')+os.pathsep+str(runtime/'lib/*'),'-d',str(classes),str(root/'tests/fixtures/TvBoxFixture.java')],check=True)
    jar=build/'fixture.jar'
    subprocess.run(['jar','cf',str(jar),'-C',str(classes),'.'],check=True)
    dex=build/'fixture-dex.jar'
    subprocess.run([str(runtime/'jre/bin/java.exe'),'-cp',str(runtime/'dex/*'),'com.googlecode.dex2jar.tools.Jar2Dex','-f','-o',str(dex),str(jar)],check=True)
    raw=build/'fixture.dex'
    with zipfile.ZipFile(dex) as z:raw.write_bytes(z.read('classes.dex'))
    cache=build/'java-test';cache.mkdir(exist_ok=True)
    args=[runtime/'jre/bin/java.exe','-Dfile.encoding=UTF-8','-Dtvbox.dex='+str(runtime/'dex-runtime/*'),'-cp',str(runtime/'host.jar')+os.pathsep+str(runtime/'lib/*'),'com.simpletools.tvbridge.Main','test-secret']
    with (build/'java-test.log').open('w',encoding='utf-8') as log:
        isolated_env={**os.environ,'JAVA_HOME':'Z:/not-installed','ANDROID_HOME':'Z:/not-installed','ANDROID_SDK_ROOT':'Z:/not-installed','PATH':os.environ.get('SystemRoot','C:/Windows')+'/System32'}
        child=subprocess.Popen(args,cwd=cache,stdout=subprocess.PIPE,stderr=log,text=True,env=isolated_env)
        try:
            origin='http://127.0.0.1:'+str(json.loads(child.stdout.readline())['port'])
            for archive in [jar,dex,raw]:
                identity=hashlib.md5(archive.read_bytes()).hexdigest()
                data={'api':'csp_TvBoxFixture','key':'fixture','ext':'custom-extension','jarData':base64.b64encode(archive.read_bytes()).decode(),'identity':identity}
                verify(origin,data,'test-secret')
                web=json.loads(request(origin+'/call',{**data,'action':'play','args':{'id':'web-id','flag':'4K','flags':[]}},'test-secret'))
                assert web['url'].startswith('proxy://go=SuperParse&flag=4K&url=')
                cached={**data,'jarData':None}
                verify(origin,cached,'test-secret')
                try:request(origin+'/health',token='wrong');raise AssertionError('Unauthorized access allowed')
                except urllib.error.HTTPError as e:assert e.code==403
                assert request(origin+'/proxy?site='+identity+'&token=test-secret')==b'DEX proxy ok'
                print('PASS: built-in JVM',archive.name,'home/category/search/detail/play, Android API adapters and media proxy')
        finally:child.terminate();child.wait(timeout=10)

if __name__=='__main__':python_test();java_test()
