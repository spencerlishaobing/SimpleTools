package android.content;
/** 桌面 Android 兼容层桩：满足外置片源的类链接/验证，桌面端无真实窗口/服务实现。 */
public class ContentValues {

    private final java.util.HashMap<String,Object> values=new java.util.HashMap<>();
    public void put(String key,String value){values.put(key,value);}
    public void put(String key,Integer value){values.put(key,value);}
    public void put(String key,Long value){values.put(key,value);}
    public void put(String key,Double value){values.put(key,value);}
    public void put(String key,Boolean value){values.put(key,value);}
    public void put(String key,byte[] value){values.put(key,value);}
    public void putAll(ContentValues other){if(other!=null)values.putAll(other.values);}
    public String getAsString(String key){Object v=values.get(key);return v==null?null:String.valueOf(v);}
    public Integer getAsInteger(String key){Object v=values.get(key);return v instanceof Integer?(Integer)v:null;}
    public Long getAsLong(String key){Object v=values.get(key);return v instanceof Long?(Long)v:null;}
    public Boolean getAsBoolean(String key){Object v=values.get(key);return v instanceof Boolean?(Boolean)v:null;}
    public void remove(String key){values.remove(key);}
    public void clear(){values.clear();}
    public int size(){return values.size();}
}
