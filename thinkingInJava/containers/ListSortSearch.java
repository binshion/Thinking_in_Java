package thinkingInJava.containers;

import java.util.ArrayList;
import java.util.List;

import static thinkingInJava.util.Print.*;

public class ListSortSearch {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Utilities.list);
        list.addAll(Utilities.list);
        print(list);
    }
}
