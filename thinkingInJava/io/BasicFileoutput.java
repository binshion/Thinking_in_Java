package thinkingInJava.io;

import java.io.*;

public class BasicFileoutput {
    static String file = "BasicFileOutput.text";
    public static void main(String[] args) throws IOException {
        BufferedReader  in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("F:/JavaProject/Thinking_in_Java/thinkingInJava/io/BasicFileOutput.java")
                )
        );

        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file))
        );

        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
        }
        out.close();

        System.out.println(BufferedInputFile.read(file));
    }
}
