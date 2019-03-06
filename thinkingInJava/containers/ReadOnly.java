package thinkingInJava.containers;

import thinkingInJava.util.Countries;

import java.util.ArrayList;
import java.util.Collection;

public class ReadOnly {
    static Collection<String> data = new ArrayList<String>(Countries.names(6));

    public static void main(String[] args){

    }
}
