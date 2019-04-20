package thinkingInJava.io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * F:\JavaProject\bin\Thinking_in_Java>java thinkingInJava.io.GZIPcompress "f:/JavaProject/Thinki
 ng_in_Java/thinkingInJava/io/GZIPcompress.java"

 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: \nGZIPcompress file\n" +
                    "\tUses GZIP compression to compress " +
                    "the file to test.gz");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(
                new FileReader(args[0])
        );
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream(
                                "f:/JavaProject/Thinking_in_Java/thinkingInJava/io/test.gz"
                        )
                )
        );

        System.out.println("Write file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();

        System.out.println("Read file");

        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(
                                new FileInputStream("f:/JavaProject/Thinking_in_Java/thinkingInJava/io/test.gz")
                        )
                )
        );

        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
    }
}
