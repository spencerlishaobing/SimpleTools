package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实列表/视图。 */
public class ListView extends AdapterView<ListAdapter> {
    public void setAdapter(ListAdapter adapter){}
    public void addHeaderView(android.view.View v){}
    public void addFooterView(android.view.View v){}
    public void setDividerHeight(int height){}
    public void setSelection(int position){}
    public void smoothScrollToPosition(int position){}
}
