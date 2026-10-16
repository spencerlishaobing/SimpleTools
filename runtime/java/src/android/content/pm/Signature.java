package android.content.pm;
/**
 * 签名桩：桌面端没有 APK 签名，而 TVBox 生态的 spider 常用签名做来源校验
 * （如 InitCheck.sigOk 的应用签名白名单）。这里内置影视仓 6.2.8 的公开签名证书
 * （APK META-INF/TVBOX.RSA 中的 X.509 证书，随每个 APK 公开分发），
 * 使其签名指纹命中片源侧的白名单，从而让依赖应用签名的片源能在桌面端运行。
 */
public class Signature {
    private static final String EMBEDDED_CERT=
        "308202d9308201c1a00302010202044072e1e7300d06092a864886f70d01010b0500301d310b300906035504061302434e31"
        +"0e300c060355040313055456424f58301e170d3232303931313032353431345a170d3437303930353032353431345a301d31"
        +"0b300906035504061302434e310e300c060355040313055456424f5830820122300d06092a864886f70d0101010500038201"
        +"0f003082010a0282010100f0ddd1a919cbd5089a941101a160a0130f0730671685fb1b4e055592d65c32041abc83d74c33a7"
        +"8c50705fffb63e2cb92d75bcadb20708c159e31453ffee6a95792139006d2ed51051bfdd19287f8b6bfb96ffda8aca63517d"
        +"935263a5053e63066d50df08a00c8c24a05974aa368b7f29d4b7040402f75f98100da1c856141dd178ccbbdf4190c4cbb936"
        +"88e05f9c6e0ba88d4f92c20bfd9edfe2b49133558c229bfcbf39f771ab4a3df236225ee00ede45b1cab0025f4cd4c8c813b7"
        +"de9b9f46cb5eb5de08f199dd1fb2e95d0ec7aabe96234ebc3712f2e0bd4f244a247b44474de6d8ce53bf302b144d0b8d68fe"
        +"fb3e74c1baa8e6f05d77e56f7c6bf704fd0203010001a321301f301d0603551d0e04160414aef6929f441d831abbb9dead43"
        +"c1f1e14f917271300d06092a864886f70d01010b05000382010100ddfecd788206e6da29b84185d6ebfba8d32c107f6e9504"
        +"61c2577532f35ca2aa43c7be3569dc8ce21600123d3d60fc650ace4d26856707fc8e5e1c5217b603e864a4c4ca04a0b09b59"
        +"0252c235c07fec195bf2f85dc1d86cda64c010e9a0e4c71c57966e79a8a9a9ea33ad947c81f913cf2acb5c2ea324442d54d1"
        +"0e96f3953283db803add3d98728297dd7eb53c0a82d4d85cd7b9093cb9aebbe7fa22f7e41b87ad1b4a5486d9bb69c46ca1b8"
        +"bb7ef7f07bde80bbf4a080531adc5d2368a537adaebdf07cca592e3cbefb70b911ce49aac84ce3540141a256d9b65a3ad3c2"
        +"d47e165c8b6469bc9a4a839e16623fcadf09204466c865b8c9032f875e24bcae66";
    private final byte[] data;
    public Signature(){this.data=hexToBytes(EMBEDDED_CERT);}
    public Signature(byte[] signature){this.data=signature==null?new byte[0]:signature;}
    public byte[] toByteArray(){return data;}
    /** 与 Android 行为一致：返回字节的十六进制小写字符串，spider 通常对它的 md5 做白名单比对。 */
    public String toCharsString(){return bytesToHex(data);}
    private static byte[] hexToBytes(String text){
        int length=text.length()/2;byte[] out=new byte[length];
        for(int i=0;i<length;i++)out[i]=(byte)Integer.parseInt(text.substring(i*2,i*2+2),16);
        return out;
    }
    private static String bytesToHex(byte[] bytes){
        StringBuilder out=new StringBuilder(bytes.length*2);
        for(byte value:bytes)out.append(String.format("%02x",value&0xff));
        return out.toString();
    }
}
