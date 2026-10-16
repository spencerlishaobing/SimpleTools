package android.content;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class ComponentName {

    private final String pkg,cls;
    public ComponentName(String pkg,String cls){this.pkg=pkg;this.cls=cls;}
    public ComponentName(android.content.Context context,String cls){this(context==null?"":context.getPackageName(),cls);}
    public ComponentName(android.content.Context context,Class<?> cls){this(context,cls==null?"":cls.getName());}
    public String getPackageName(){return pkg;}
    public String getClassName(){return cls;}
    public String getShortClassName(){return cls==null?null:cls.substring(cls.lastIndexOf('.')+1);}
    public String flattenToString(){return pkg+"/"+cls;}
    public String toString(){return "ComponentInfo{"+pkg+"/"+cls+"}";}
}
