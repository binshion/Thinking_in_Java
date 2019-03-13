package thinkingInJava.containers;

import thinkingInJava.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Enumerations {
    public static void main(String[] args){
        Vector<String> v = new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + ", ");
        }

        //Collections.enumeration()方法可以从Collection生成一个Enumeration
        e = Collections.enumeration(new ArrayList<String>());
    }
}
