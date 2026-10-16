package android.widget;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证。 */
public interface Adapter {
    int getCount();
    Object getItem(int position);
    long getItemId(int position);
}
