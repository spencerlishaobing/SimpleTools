package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实列表/视图。 */
public class GridView extends AdapterView<ListAdapter> {
    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public LayoutParams(){}
        public LayoutParams(int width,int height){super(width,height);}
    }
    public void setAdapter(ListAdapter adapter){}
    public void setNumColumns(int numColumns){}
}
