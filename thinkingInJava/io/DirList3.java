package thinkingInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 定义一个座位list()参数的匿名内部类，因为DirList2过于紧耦合
 */
public class DirList3 {
    public static void main(String[] args) {
        List<File> paths = new ArrayList<>();
        paths.add(new File("."));
        paths.add(new File(".."));
        paths.add(new File("d:/"));
        paths.add(new File("e:/"));

        for (File path : paths) {
            String[] list;
            if (args.length == 0) {
                list = path.list();
            } else {
                list = path.list(new FilenameFilter() {
                    Pattern pattern = Pattern.compile(args[0]);

                    @Override
                    public boolean accept(File dir, String name) {
                        return pattern.matcher(name).matches();
                    }
                });
            }

            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
            for (String dirItem : list) {
                System.out.print(dirItem + " ");
            }
            System.out.println();
            System.out.println("************************");
        }
    }
}
