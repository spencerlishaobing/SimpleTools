package android.app;
/** 桌面 Android 兼容层桩：满足外置片源的类链接与验证，桌面端无真实窗口服务实现。 */
public class Dialog {
    // 探测：记录 JAR 尝试弹窗的位置（扫码登录等），用于桌面端转发 UI
    protected static void probe(String kind,String detail){
        try{
            StringBuilder sb=new StringBuilder("[UI-PROBE] ").append(kind);
            if(detail!=null&&!detail.isEmpty())sb.append(" detail=").append(detail.length()>300?detail.substring(0,300):detail);
            StackTraceElement[] st=Thread.currentThread().getStackTrace();
            sb.append(" | caller=");
            for(int i=3;i<Math.min(st.length,9);i++)sb.append(st[i].getClassName()).append('.').append(st[i].getMethodName()).append("<-");
            System.err.println(sb);
        }catch(Throwable ignored){}
    }

    public Dialog(){}
    public Dialog(android.content.Context context){}
    public void show(){probe("Dialog.show",null);}
    public void dismiss(){}
    public void cancel(){}
    public boolean isShowing(){return false;}
    public void setTitle(CharSequence title){probe("Dialog.setTitle",title==null?"":title.toString());}
    public void setCancelable(boolean flag){}
}
