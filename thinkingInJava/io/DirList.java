package thinkingInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * File类名称存在误导性，实际上FilePath(文件路径)对这个类来说是个更好的名字。
 */
public class DirList {
    public static void main(String[] args) {
        List<File> paths = new ArrayList<>();
        paths.add(new File("."));
        paths.add(new File(".."));
        paths.add(new File("d:/"));
        paths.add(new File("e:/"));

        printPathname(paths, args);

    }

    public static void printPathname(List<File> paths, String[] args) {
        for (File path : paths) {
            String[] list;
            if (args.length == 0) {
                list = path.list();
            } else {
                list = path.list(new DirFilter(args[0]));
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

/**
 * 提供accept()方法给list()使用，这种结构也称之为回调。
 *     这也是一个策略模式的例子：list()实现了基本功能，接受FilenameFilter对象作为参数。因此可以传递实现了
 * FilenameFilter接口的任何对象。策略目的是为了提供代码行为的灵活性。
 */
class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
