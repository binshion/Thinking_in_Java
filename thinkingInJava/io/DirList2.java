package thinkingInJava.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 使用匿名内部类
 */
public class DirList2 {
    public static FilenameFilter filter(final String regex) {
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    public static void main(String[] args) {
        List<File> paths =  new ArrayList<>();
        paths.add(new File("."));
        paths.add(new File(".."));
        paths.add(new File("d:/"));
        paths.add(new File("e:/"));

        DirList.printPathname(paths, args);
    }
}
