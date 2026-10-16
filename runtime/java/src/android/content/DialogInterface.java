package android.content;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public interface DialogInterface {
    interface OnClickListener {void onClick(DialogInterface dialog,int which);}
    interface OnDismissListener {void onDismiss(DialogInterface dialog);}
    interface OnCancelListener {void onCancel(DialogInterface dialog);}
    interface OnShowListener {void onShow(DialogInterface dialog);}
    interface OnMultiChoiceClickListener {void onClick(DialogInterface dialog,int which,boolean isChecked);}
    interface OnKeyListener {boolean onKey(DialogInterface dialog,int keyCode,android.view.KeyEvent event);}
}
