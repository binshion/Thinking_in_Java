package thinkingInJava.containers;

import thinkingInJava.util.CountingMapData;

import java.util.LinkedHashMap;

import static thinkingInJava.util.Print.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        print(linkedMap);
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);  //最近最少使用
        linkedMap.putAll(new CountingMapData(9));
        print(linkedMap);

        for (int i = 0; i < 6; i++) {
            linkedMap.get(i);
        }

        print(linkedMap);
        linkedMap.get(0);
        print(linkedMap);
    }
}
