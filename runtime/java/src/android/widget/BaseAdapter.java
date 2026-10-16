package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实列表/视图。 */
public abstract class BaseAdapter implements ListAdapter,SpinnerAdapter {
    public int getCount(){return 0;}
    public Object getItem(int position){return null;}
    public long getItemId(int position){return position;}
    public boolean areAllItemsEnabled(){return true;}
    public boolean isEnabled(int position){return true;}
    public boolean isEmpty(){return getCount()==0;}
    public void notifyDataSetChanged(){}
    public void notifyDataSetInvalidated(){}
}
