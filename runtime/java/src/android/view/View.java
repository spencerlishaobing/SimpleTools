package android.view;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class View {

    public interface OnClickListener {void onClick(View v);}
    public interface OnLongClickListener {boolean onLongClick(View v);}
    public interface OnTouchListener {boolean onTouch(View v,MotionEvent event);}
    public interface OnKeyListener {boolean onKey(View v,int keyCode,KeyEvent event);}
    public interface OnFocusChangeListener {void onFocusChange(View v,boolean hasFocus);}
    public static final int VISIBLE=0,INVISIBLE=4,GONE=8;
    private int id,visibility=VISIBLE;
    public View(){}
    public View(android.content.Context context){}
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public int getVisibility(){return visibility;}
    public void setVisibility(int visibility){this.visibility=visibility;}
    public void setOnClickListener(OnClickListener listener){}
    public void setOnLongClickListener(OnLongClickListener listener){}
    public void setOnTouchListener(OnTouchListener listener){}
    public void setTag(Object tag){}
    public Object getTag(){return null;}
}
