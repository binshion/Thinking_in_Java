package thinkingInJava.containers;

import java.util.ArrayList;
import java.util.List;

/**
 * Creating a good hashCode().
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
}
