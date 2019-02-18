package thinkingInJava.containers;

import static thinkingInJava.util.Print.*;

public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1]);
            if (i < index - 1) {  //非最后一个需要换行
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        AssociativeArray<String,String> map = new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("sun", "warm");
        map.put("earth", "brown");

        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            print(e);
        }

        print(map);
        print(map.get("sun"));
    }
}
