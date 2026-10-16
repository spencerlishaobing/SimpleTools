"""Private loopback TVBox Python worker. No third party code runs in the UI process."""
import argparse
import contextlib
import hashlib
import importlib.util
import inspect
import json
import os
import sys
import threading
import traceback
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer
from pathlib import Path
from urllib.parse import parse_qs, urlencode, urlsplit

instances = {}
lock = threading.RLock()

def result(value):
    if isinstance(value, str): return json.loads(value) if value.strip() else {}
    return value or {}

def dispatch(data, origin, token):
    identity = hashlib.sha256((data['api'] + json.dumps(data.get('ext', ''), sort_keys=True) + data['key'] + data['source']).encode()).hexdigest()
    with lock:
        if identity not in instances:
            folder = Path('sources') / identity
            folder.mkdir(parents=True, exist_ok=True)
            script = folder / 'source.py'
            script.write_text(data['source'], encoding='utf-8')
            spec = importlib.util.spec_from_file_location('tvbox_' + identity, script)
            module = importlib.util.module_from_spec(spec)
            sys.modules[spec.name] = module
            spec.loader.exec_module(module)
            spider = module.Spider()
            spider._proxy_url = origin + '/proxy?' + urlencode({'token':token,'site':identity,'do':'py'})
            spider.init(data.get('ext',''))
            if len(instances) >= 32:
                old = instances.pop(next(iter(instances)))
                with contextlib.suppress(Exception): old.destroy()
            instances[identity] = spider
        spider = instances[identity]
        args = data.get('args', {})
        action = data['action']
        if action == 'home':
            value = result(spider.homeContent(True))
            if not value.get('list'):
                value['list'] = result(spider.homeVideoContent()).get('list', [])
        elif action == 'category': value = spider.categoryContent(str(args.get('t','')), str(args.get('page',1)), True, args.get('filters',{}))
        elif action == 'detail': value = spider.detailContent([str(args['id'])])
        elif action == 'search':
            params = [args['keyword'], False, str(args.get('page',1))]
            if len(inspect.signature(spider.searchContent).parameters) < 3: params.pop()
            value = spider.searchContent(*params)
        elif action == 'play': value = spider.playerContent(args.get('flag',''), args['id'], args.get('flags',[]))
        else: raise ValueError('Unsupported action: '+action)
        return result(value)

class Handler(BaseHTTPRequestHandler):
    def log_message(self, *args): pass
    def send(self, code, data, content_type='application/json; charset=utf-8', headers=None):
        if not isinstance(data, bytes): data = data.encode('utf-8')
        self.send_response(int(code))
        self.send_header('Content-Type',content_type)
        self.send_header('Content-Length',str(len(data)))
        for key,value in (headers or {}).items():
            if key.lower() not in ('content-length','transfer-encoding','connection','content-type'): self.send_header(key,str(value))
        self.end_headers()
        self.wfile.write(data)
    def authorized(self, query):
        return self.headers.get('X-TVBOX-Token') == self.server.token or query.get('token',[''])[0] == self.server.token
    def do_GET(self):
        path = urlsplit(self.path); query = parse_qs(path.query)
        if not self.authorized(query): return self.send(403,'{}')
        if path.path == '/health': return self.send(200,'{}')
        if path.path != '/proxy': return self.send(404,'{}')
        try:
            params = {k:v[-1] for k,v in query.items() if k not in ('token','site')}
            params['headers'] = dict(self.headers)
            with lock:
                value = instances[query['site'][0]].localProxy(params)
            self.send(value[0],value[2],value[1],value[3] if len(value)>3 else {})
        except Exception as exc: self.send(502,json.dumps({'error':str(exc)}))
    def do_POST(self):
        if not self.authorized({}): return self.send(403,'{}')
        if self.path != '/call': return self.send(404,'{}')
        size = int(self.headers.get('Content-Length','0'))
        if size < 1 or size > 8*1024*1024: return self.send(413,'{}')
        try:
            data = json.loads(self.rfile.read(size))
            value = dispatch(data, 'http://127.0.0.1:'+str(self.server.server_port), self.server.token)
            self.send(200,json.dumps(value,ensure_ascii=False))
        except Exception as exc:
            traceback.print_exc()
            self.send(500,json.dumps({'error':str(exc)}))

if __name__ == '__main__':
    parser = argparse.ArgumentParser(); parser.add_argument('--token',required=True); parser.add_argument('--port',type=int,default=0)
    args = parser.parse_args()
    server = ThreadingHTTPServer(('127.0.0.1',args.port),Handler)
    server.token = args.token
    print(json.dumps({'port':server.server_port}),flush=True)
    server.serve_forever()
