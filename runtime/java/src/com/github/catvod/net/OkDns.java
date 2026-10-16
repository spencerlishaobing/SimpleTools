package com.github.catvod.net;
import java.net.*;
import java.util.*;
public class OkDns implements okhttp3.Dns {
    private final Map<String,String> hosts=new java.util.concurrent.ConcurrentHashMap<>();
    public void addAll(List<String> values){if(values!=null)for(String value:values){if(value==null)continue;String[] pair=value.split("=",2);if(pair.length==2)hosts.put(pair[0].trim(),pair[1].trim());}}
    public void clear(){hosts.clear();}
    public List<InetAddress> lookup(String host)throws UnknownHostException{return okhttp3.Dns.SYSTEM.lookup(hosts.getOrDefault(host,host));}
}
