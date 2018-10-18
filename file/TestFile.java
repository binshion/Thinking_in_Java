package file;

import java.io.File;

public class TestFile {
    public static void main(String[] args){
        File f1 = new File("name.text");
        System.out.println(f1.getAbsolutePath());
    }
}
