package android.os;
import java.util.HashMap;
/** 桌面端 Bundle：内存键值袋，覆盖 spider 常用类型。 */
public class Bundle {
    private final HashMap<String,Object> values=new HashMap<>();
    public Bundle(){}
    public Bundle(Bundle other){if(other!=null)values.putAll(other.values);}
    public void putString(String key,String value){values.put(key,value);}
    public String getString(String key){Object v=values.get(key);return v==null?null:String.valueOf(v);}
    public String getString(String key,String fallback){return values.containsKey(key)?getString(key):fallback;}
    public void putCharSequence(String key,CharSequence value){values.put(key,value);}
    public CharSequence getCharSequence(String key){Object v=values.get(key);return v==null?null:(CharSequence)v;}
    public void putInt(String key,int value){values.put(key,value);}
    public int getInt(String key){Object v=values.get(key);return v instanceof Number?((Number)v).intValue():0;}
    public int getInt(String key,int fallback){return values.containsKey(key)?getInt(key):fallback;}
    public void putLong(String key,long value){values.put(key,value);}
    public long getLong(String key){Object v=values.get(key);return v instanceof Number?((Number)v).longValue():0L;}
    public long getLong(String key,long fallback){return values.containsKey(key)?getLong(key):fallback;}
    public void putBoolean(String key,boolean value){values.put(key,value);}
    public boolean getBoolean(String key){Object v=values.get(key);return v instanceof Boolean&&(Boolean)v;}
    public boolean getBoolean(String key,boolean fallback){return values.containsKey(key)?getBoolean(key):fallback;}
    public void putFloat(String key,float value){values.put(key,value);}
    public float getFloat(String key){Object v=values.get(key);return v instanceof Number?((Number)v).floatValue():0f;}
    public void putDouble(String key,double value){values.put(key,value);}
    public double getDouble(String key){Object v=values.get(key);return v instanceof Number?((Number)v).doubleValue():0d;}
    public void putSerializable(String key,java.io.Serializable value){values.put(key,value);}
    public java.io.Serializable getSerializable(String key){Object v=values.get(key);return v instanceof java.io.Serializable?(java.io.Serializable)v:null;}
    public void putStringArrayList(String key,java.util.ArrayList<String> value){values.put(key,value);}
    @SuppressWarnings("unchecked")
    public java.util.ArrayList<String> getStringArrayList(String key){Object v=values.get(key);return v instanceof java.util.ArrayList?(java.util.ArrayList<String>)v:null;}
    public Object get(String key){return values.get(key);}
    public void putAll(Bundle other){if(other!=null)values.putAll(other.values);}
    public boolean containsKey(String key){return values.containsKey(key);}
    public void remove(String key){values.remove(key);}
    public java.util.Set<String> keySet(){return values.keySet();}
    public int size(){return values.size();}
    public boolean isEmpty(){return values.isEmpty();}
    public void clear(){values.clear();}
}
