package thinkingInJava.io;

import thinkingInJava.util.Directory;
import thinkingInJava.util.PPrint;
import static thinkingInJava.util.Print.*;

import java.io.File;

public class DirectoryDeme {
    public static void main(String[] args) {
        PPrint.pprint(Directory.walk(".").dirs);

        for (File file : Directory.local(".", "T.*")) {
            print(file);
        }
        print("----------------------");

        for (File file : Directory.walk(".", "T.*\\.java")) {
            print(file);
        }
        print("=========================");

        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            print(file);
        }
    }
}
