package thinkingInJava.containers;

import thinkingInJava.util.Countries;

import java.util.*;

/**
 * A Map implementedwith ArrayLists.
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }

        return oldValue;
    }

    public V get(Object key) {  //key is type of Object, not K
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<Map.Entry<K,V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();

        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return null;
    }

    public static void main(String[] args){
        SlowMap<String,String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));

        System.out.println(m);
        System.out.println(m.get("BRAZIL"));
        System.out.println(m.entrySet());
    }
}
