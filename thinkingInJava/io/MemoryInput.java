package thinkingInJava.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从BufferedInputFile.read()读入的String结果被用来创建一个StringReader.
 * 调用read()每次读取一个字符，并把它发送给控制台。
 * StringReader.read()以int形式返回下一字节，因此必须类型转换为char才能正确打印。
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("F:/JavaProject/Thinking_in_Java/thinkingInJava/io/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
