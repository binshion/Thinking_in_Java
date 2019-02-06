package thinkingInJava.util;

import java.util.*;

import static thinkingInJava.util.Print.*;

public class Countries {
    public static final String[][] DATA = {
            //Africa
            {"ALGERIA", "Algiers"},
            {"ANGOLA", "Luanda"},
            //Asia
            {"BAHRAIN", "Manama"},
            {"CHINA", "Beijing"},
            {"IRAN", "Tehran"},
            //Australia and Oceania
            {"AUSTRALIA", "Canberra"},
            {"NEW ZEALAND", "Wellington"},
            //Europe
            {"GERMANY", "Berlin"},
            {"CANADA", "Ottawa"},
            //South America
            {"BRAZIL", "Brasilia"}
    };

    private static class FlyweightMap extends AbstractMap<String,String> {
        private static class Entry implements Map.Entry<String,String> {
            int index;
            Entry(int index) {
                this.index = index;
            }

            @Override
            public boolean equals(Object obj) {
                return DATA[index][0].equals(obj);
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<String,String>> {
            private int size;
            EntrySet(int size) {
                if(size < 0) {
                    this.size = 0;
                }
                else if(size > DATA.length) {
                    this.size = DATA.length;
                }
                else {
                    this.size = size;
                }
            }

            public int size() {
                return size;
            }

            private class Iter implements Iterator<Map.Entry<String,String>> {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                public Map.Entry<String,String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            public Iterator<Map.Entry<String,String>> iterator() {
                return new Iter();
            }
        }

        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);

        public Set<Map.Entry<String,String>> entrySet() {
            return entries;
        }
    }

    static Map<String,String> select(final int size) {
        return new FlyweightMap() {
            public Set<Map.Entry<String,String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String,String> map = new FlyweightMap();
    public static Map<String,String> capitals() {
        return map;
    }

    public static Map<String,String> capitals(int size) {
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());

    public static List<String> names() {
        return names;
    }

    public static List<String> names(int size) {
        return new ArrayList<String>(select(size).keySet());
    }

    public static void main(String[] args) {
        print(capitals(10));
    }
}
