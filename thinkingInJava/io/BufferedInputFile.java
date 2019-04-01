package thinkingInJava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 使用以String或File对象作为文件名的FileInputReader(此案例使用的是FileReader).
 * 为了提高速度，对这个文件进行缓冲，那么我们将所产生的引用传给一个
 * BufferedReader构造器。由于BufferedReader也提供readLine()方法，
 * 所以这是我们的最终对象和进行读取的接口。
 * 当readLine()将返回null时，达到了文件的末尾。
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader(filename)
        );
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();  //对文件显式地调用close()
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("F:/JavaProject/Thinking_in_Java/thinkingInJava/io/BufferedInputFile.java"));
    }
}
