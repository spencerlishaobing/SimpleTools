package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实列表/视图。 */
public interface ListAdapter extends Adapter {
    boolean areAllItemsEnabled();
    boolean isEnabled(int position);
}
