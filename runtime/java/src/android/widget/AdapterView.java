package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实列表/视图。 */
public class AdapterView<T extends Adapter> extends android.view.ViewGroup {
    public interface OnItemClickListener {void onItemClick(AdapterView<?> parent,android.view.View view,int position,long id);}
    public interface OnItemLongClickListener {boolean onItemLongClick(AdapterView<?> parent,android.view.View view,int position,long id);}
    public interface OnItemSelectedListener {void onItemSelected(AdapterView<?> parent,android.view.View view,int position,long id);void onNothingSelected(AdapterView<?> parent);}
    public void setOnItemClickListener(OnItemClickListener listener){}
    public void setOnItemLongClickListener(OnItemLongClickListener listener){}
    public void setOnItemSelectedListener(OnItemSelectedListener listener){}
    public void setAdapter(T adapter){}
    public T getAdapter(){return null;}
    public Object getSelectedItem(){return null;}
    public int getSelectedItemPosition(){return -1;}
    public void setSelection(int position){}
}
