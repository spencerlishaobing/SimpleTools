package androidx.collection;
public class ArrayMap<K,V> extends SimpleArrayMap<K,V> {
    public ArrayMap(){}public ArrayMap(int capacity){super(capacity);}public ArrayMap(SimpleArrayMap<K,V> source){super(source);}
    public boolean containsAll(java.util.Collection<?> keys){return keySet().containsAll(keys);}public boolean removeAll(java.util.Collection<?> keys){return keySet().removeAll(keys);}public boolean retainAll(java.util.Collection<?> keys){return keySet().retainAll(keys);}
}
