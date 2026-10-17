package com.github.catvod.net;
import okhttp3.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class OkHttp {
    private static OkDns dns=new OkDns();
    private static OkHttpClient client;
    public static synchronized OkHttpClient client(){if(client==null)client=new OkHttpClient.Builder().dns(dns()).connectTimeout(30,TimeUnit.SECONDS).readTimeout(30,TimeUnit.SECONDS).writeTimeout(30,TimeUnit.SECONDS).build();return client;}
    public static synchronized OkDns dns(){return dns;}
    public static OkHttpClient player(){return client();}
    public static OkHttpClient client(long timeout){return client().newBuilder().connectTimeout(timeout,TimeUnit.MILLISECONDS).readTimeout(timeout,TimeUnit.MILLISECONDS).writeTimeout(timeout,TimeUnit.MILLISECONDS).build();}
    public static OkHttpClient client(boolean redirect,long timeout){return client(timeout).newBuilder().followRedirects(redirect).followSslRedirects(redirect).build();}
    public static OkHttpClient noRedirect(){return noRedirect(30000);}public static OkHttpClient noRedirect(long timeout){return client(false,timeout);}
    public static synchronized void reset(){client=null;dns=new OkDns();}public static synchronized void resetClient(){client=null;}
    private static String read(Call call){try(Response response=call.execute()){String text=response.body()==null?"":response.body().string();android.util.Log.d("OkHttp",call.request().url()+" -> "+response.code()+" len="+text.length());return text;}catch(Exception e){android.util.Log.e("OkHttp","Request failed: "+call.request().url(),e);return "";}}
    public static String string(String url){return read(newCall(url));}public static String string(String url,long timeout){return read(newCall(client(timeout),url));}public static String string(String url,Map<String,String> headers){return read(newCall(url,headers));}
    private static Headers headers(Map<String,String> map){return map==null?new Headers.Builder().build():Headers.of(map);}
    public static Call newCall(String url){return newCall(client(),url);}public static Call newCall(String url,String tag){return newCall(client(),url,tag);}
    public static Call newCall(OkHttpClient client,String url){return client.newCall(new Request.Builder().url(url).build());}
    public static Call newCall(OkHttpClient client,String url,String tag){return client.newCall(new Request.Builder().url(url).tag(tag).build());}
    public static Call newCall(String url,Map<String,String> headers){return client().newCall(new Request.Builder().url(url).headers(headers(headers)).build());}
    public static Call newCall(String url,Map<String,String> headers,androidx.collection.ArrayMap<String,String> params){HttpUrl.Builder builder=HttpUrl.get(url).newBuilder();if(params!=null)for(Map.Entry<String,String> e:params.entrySet())builder.addQueryParameter(e.getKey(),e.getValue());return newCall(builder.build().toString(),headers);}
    public static Call newCall(String url,Map<String,String> headers,RequestBody body){return client().newCall(new Request.Builder().url(url).headers(headers(headers)).post(body).build());}
    public static Call newCall(String url,RequestBody body,String tag){return client().newCall(new Request.Builder().url(url).tag(tag).post(body).build());}
    public static Call newCall(OkHttpClient client,String url,RequestBody body){return client.newCall(new Request.Builder().url(url).post(body).build());}
    public static void cancel(String tag){cancel(client(),tag);}public static void cancel(OkHttpClient client,String tag){if(client==null||tag==null)return;for(Call call:client.dispatcher().queuedCalls())if(tag.equals(call.request().tag()))call.cancel();for(Call call:client.dispatcher().runningCalls())if(tag.equals(call.request().tag()))call.cancel();}
    public static void cancelAll(){cancelAll(client());}public static void cancelAll(OkHttpClient client){if(client!=null)client.dispatcher().cancelAll();}
    public static FormBody toBody(androidx.collection.ArrayMap<String,String> params){FormBody.Builder builder=new FormBody.Builder();if(params!=null)for(Map.Entry<String,String> e:params.entrySet())builder.add(e.getKey(),e.getValue());return builder.build();}
}
