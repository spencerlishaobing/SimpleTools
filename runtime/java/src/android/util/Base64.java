package android.util;
public final class Base64 {
 public static final int DEFAULT=0,NO_PADDING=1,NO_WRAP=2,CRLF=4,URL_SAFE=8,NO_CLOSE=16;
 public static byte[] decode(String s,int f){return ((f&URL_SAFE)!=0?java.util.Base64.getUrlDecoder():java.util.Base64.getDecoder()).decode(s.replaceAll("\\s", ""));}
 public static byte[] decode(byte[] b,int f){return decode(new String(b,java.nio.charset.StandardCharsets.US_ASCII),f);}
 public static byte[] decode(byte[] b,int off,int len,int f){return decode(java.util.Arrays.copyOfRange(b,off,off+len),f);}
 public static String encodeToString(byte[] b,int f){return new String(encode(b,f),java.nio.charset.StandardCharsets.US_ASCII);}
 public static String encodeToString(byte[] b,int off,int len,int f){return encodeToString(java.util.Arrays.copyOfRange(b,off,off+len),f);}
 public static byte[] encode(byte[] b,int f){java.util.Base64.Encoder e=(f&URL_SAFE)!=0?java.util.Base64.getUrlEncoder():java.util.Base64.getEncoder();if((f&NO_PADDING)!=0)e=e.withoutPadding();String s=e.encodeToString(b);if((f&NO_WRAP)==0&&!s.isEmpty()){String newline=(f&CRLF)!=0?"\r\n":"\n";StringBuilder out=new StringBuilder();for(int i=0;i<s.length();i+=76)out.append(s, i, Math.min(i+76,s.length())).append(newline);s=out.toString();}return s.getBytes(java.nio.charset.StandardCharsets.US_ASCII);}
 public static byte[] encode(byte[] b,int off,int len,int f){return encode(java.util.Arrays.copyOfRange(b,off,off+len),f);}
}