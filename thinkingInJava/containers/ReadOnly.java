package thinkingInJava.containers;

import thinkingInJava.util.Countries;

import java.util.*;

import static thinkingInJava.util.Print.*;

public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args){
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        print(c);

        //Can't change it!
//        c.add("one");

        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        print(lit.next());  //读取正常
//        lit.add("one");  //不能修改

        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        print(s);
//        s.add("one");  //不能修改

        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));

        Map<String,String> m = Collections.unmodifiableMap(new HashMap<>(Countries.capitals(6)));
        print(m);
//        m.put("Ralph", "Howdy!");  //不能修改

        Map<String,String> sm = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(6)));
    }
}
