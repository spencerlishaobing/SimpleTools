package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class ArrayAdapter implements Adapter {

    public ArrayAdapter(android.content.Context context,int resource){}
    public ArrayAdapter(android.content.Context context,int resource,java.util.List<?> objects){}
    public ArrayAdapter(android.content.Context context,int resource,Object[] objects){}
    public void add(Object object){}
    public void notifyDataSetChanged(){}
    public Object getItem(int position){return null;}
    public int getCount(){return 0;}
    public long getItemId(int position){return position;}
}
