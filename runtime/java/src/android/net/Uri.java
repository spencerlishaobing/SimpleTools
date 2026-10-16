package android.net;
import java.net.*;
import java.util.*;
public final class Uri {
    private final String value;
    private Uri(String value){this.value=value;}
    public static Uri parse(String value){return new Uri(value);}public static Uri fromFile(java.io.File file){return parse(file.toURI().toString());}
    private URI uri(){return URI.create(value.replace(" ","%20"));}
    public String getScheme(){return uri().getScheme();}public String getHost(){return uri().getHost();}public int getPort(){return uri().getPort();}public String getPath(){return uri().getPath();}public String getQuery(){return uri().getQuery();}public String getEncodedQuery(){return uri().getRawQuery();}public String getFragment(){return uri().getFragment();}public String getAuthority(){return uri().getAuthority();}
    public String getLastPathSegment(){List<String> parts=getPathSegments();return parts.isEmpty()?null:parts.get(parts.size()-1);}public List<String> getPathSegments(){List<String> out=new ArrayList<>();for(String p:uri().getRawPath().split("/"))if(!p.isEmpty())out.add(decode(p));return out;}
    public String getQueryParameter(String key){List<String> values=getQueryParameters(key);return values.isEmpty()?null:values.get(0);}public List<String> getQueryParameters(String key){List<String> out=new ArrayList<>();String query=getEncodedQuery();if(query!=null)for(String pair:query.split("&")){String[] p=pair.split("=",2);if(decode(p[0]).equals(key))out.add(p.length>1?decode(p[1]):"");}return out;}
    public static String decode(String s){try{return URLDecoder.decode(s,"UTF-8");}catch(Exception e){throw new IllegalArgumentException(e);}}
    public static String encode(String s){try{return URLEncoder.encode(s,"UTF-8").replace("+","%20");}catch(Exception e){throw new IllegalArgumentException(e);}}
    public static String encode(String s,String allow){String encoded=encode(s);if(allow!=null)for(char c:allow.toCharArray())encoded=encoded.replace(encode(String.valueOf(c)),String.valueOf(c));return encoded;}
    public Builder buildUpon(){return new Builder(value);}public String toString(){return value;}
    public static final class Builder {
        String scheme,authority,path="",query,fragment;
        public Builder(){}Builder(String value){URI u=URI.create(value);scheme=u.getScheme();authority=u.getRawAuthority();path=u.getRawPath();query=u.getRawQuery();fragment=u.getRawFragment();}
        public Builder scheme(String s){scheme=s;return this;}public Builder authority(String s){authority=s;return this;}public Builder path(String s){path=s;return this;}public Builder encodedPath(String s){path=s;return this;}
        public Builder appendPath(String s){return appendEncodedPath(encode(s));}public Builder appendEncodedPath(String s){path=(path.endsWith("/")?path:path+"/")+s;return this;}
        public Builder appendQueryParameter(String k,String v){query=(query==null||query.isEmpty()?"":query+"&")+encode(k)+"="+encode(v);return this;}public Builder clearQuery(){query=null;return this;}public Builder encodedQuery(String s){query=s;return this;}public Builder fragment(String s){fragment=encode(s);return this;}
        public Uri build(){return Uri.parse((scheme==null?"":scheme+":")+(authority==null?"":"//"+authority)+path+(query==null?"":"?"+query)+(fragment==null?"":"#"+fragment));}
    }
}
