package androidx.collection;
import java.util.*;
public class SimpleArrayMap<K,V> extends LinkedHashMap<K,V> {
    public SimpleArrayMap(){}public SimpleArrayMap(int capacity){super(capacity);}public SimpleArrayMap(SimpleArrayMap<K,V> source){super(source);}
    public K keyAt(int index){return new ArrayList<>(keySet()).get(index);}public V valueAt(int index){return get(keyAt(index));}
    public V setValueAt(int index,V value){return put(keyAt(index),value);}public V removeAt(int index){return remove(keyAt(index));}
    public int indexOfKey(Object key){return new ArrayList<>(keySet()).indexOf(key);}public int indexOfValue(Object value){return new ArrayList<>(values()).indexOf(value);}
    public void ensureCapacity(int capacity){}public void putAll(SimpleArrayMap<? extends K,? extends V> map){super.putAll(map);}
}
