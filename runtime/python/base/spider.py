"""Desktop implementation of the public TVBox Python Spider interface."""
import json
import re
import requests
from lxml import etree

class Spider:
    def __init__(self):
        self.extend = ''
        self._proxy_url = ''
    def init(self, extend=''): self.extend = extend
    def setExtendInfo(self, extend): self.extend = extend
    def getDependence(self): return []
    def homeContent(self, filter): return {}
    def homeVideoContent(self): return {}
    def categoryContent(self, tid, pg, filter, extend): return {}
    def detailContent(self, ids): return {}
    def searchContent(self, key, quick, pg='1'): return {}
    def playerContent(self, flag, id, vipFlags): return {}
    def localProxy(self, param): return [404, 'text/plain', 'No proxy handler']
    def destroy(self): pass
    def getProxyUrl(self, local=True): return self._proxy_url
    def fetch(self, url, **kwargs):
        kwargs.setdefault('timeout', 20)
        response = requests.get(url, **kwargs)
        response.encoding = response.apparent_encoding or 'utf-8'
        return response
    def post(self, url, **kwargs):
        kwargs.setdefault('timeout', 20)
        response = requests.post(url, **kwargs)
        response.encoding = response.apparent_encoding or 'utf-8'
        return response
    def postJson(self, url, json, headers=None, cookies=None): return self.post(url,json=json,headers=headers,cookies=cookies)
    def html(self, content): return etree.HTML(content)
    def xpText(self, root, expr):
        values = root.xpath(expr)
        return values[0] if values else ''
    def regStr(self, src, reg=None, group=1):
        match = re.search(reg, src) if reg else None
        return match.group(group) if match else ''
    def removeHtmlTags(self, src): return re.sub('<[^>]+>', '', src)
    def cleanText(self, src): return re.sub('[\U0001f300-\U0001faff]', '', src)
    def str2json(self, content): return json.loads(content)
    def json2str(self, content): return json.dumps(content, ensure_ascii=False)
    def log(self, msg): print(msg, flush=True)
