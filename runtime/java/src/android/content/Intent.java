package android.content;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class Intent {

    public static final String ACTION_VIEW="android.intent.action.VIEW";
    public static final int FLAG_ACTIVITY_NEW_TASK=0x10000000;
    private String action;
    private android.net.Uri data;
    private int flags;
    private final java.util.HashMap<String,Object> extras=new java.util.HashMap<>();
    public Intent(){}
    public Intent(String action){this.action=action;}
    public Intent(android.content.Context context,Class<?> cls){}
    public Intent(String action,android.net.Uri data){this.action=action;this.data=data;}
    public Intent setAction(String action){this.action=action;return this;}
    public String getAction(){return action;}
    public Intent setData(android.net.Uri data){this.data=data;return this;}
    public android.net.Uri getData(){return data;}
    public String getDataString(){return data==null?null:data.toString();}
    public Intent setFlags(int flags){this.flags=flags;return this;}
    public Intent addFlags(int flags){this.flags|=flags;return this;}
    public int getFlags(){return flags;}
    public Intent putExtra(String name,String value){extras.put(name,value);return this;}
    public Intent putExtra(String name,int value){extras.put(name,value);return this;}
    public Intent putExtra(String name,boolean value){extras.put(name,value);return this;}
    public Intent putExtra(String name,long value){extras.put(name,value);return this;}
    public String getStringExtra(String name){Object v=extras.get(name);return v==null?null:String.valueOf(v);}
    public int getIntExtra(String name,int fallback){Object v=extras.get(name);return v instanceof Integer?(Integer)v:fallback;}
    public boolean getBooleanExtra(String name,boolean fallback){Object v=extras.get(name);return v instanceof Boolean?(Boolean)v:fallback;}
    public Intent setClassName(String pkg,String cls){return this;}
    public Intent setPackage(String pkg){return this;}
    public Intent setComponent(ComponentName component){return this;}
    public ComponentName getComponent(){return null;}
}
