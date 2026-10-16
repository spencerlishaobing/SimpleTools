from base.spider import Spider as BaseSpider
from Crypto.Cipher import AES
from lxml import etree
import requests, bs4, pyquery, jsonpath, cachetools, ujson

class Spider(BaseSpider):
    def init(self, extend=''):
        self.extend=extend
        self.calls=0
    def homeContent(self, filter):
        self.calls+=1
        return {'class':[{'type_id':'1','type_name':'Python 分类'}]}
    def homeVideoContent(self): return {'list':[{'vod_id':'1','vod_name':'Python 电影'}]}
    def categoryContent(self, tid, pg, filter, extend): return {'list':[{'vod_id':tid,'vod_name':extend.get('year','')}],'page':pg}
    def detailContent(self, ids): return {'list':[{'vod_id':ids[0],'vod_name':'Python 电影','vod_play_from':'测试','vod_play_url':'第一集$test-id'}]}
    def searchContent(self, key, quick, pg='1'): return {'list':[{'vod_id':'1','vod_name':key}],'page':pg}
    def playerContent(self, flag, id, vipFlags): return {'parse':0,'url':self.getProxyUrl()+'&action=media','header':{'X-Extend':self.extend},'calls':self.calls}
    def localProxy(self, param): return [200,'text/plain',b'Python proxy ok']
