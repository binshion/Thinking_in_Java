package thinkingInJava.containers;

import java.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    static final int SIZE = 997;

    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
