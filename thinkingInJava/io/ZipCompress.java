package thinkingInJava.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

import static thinkingInJava.util.Print.*;

public class ZipCompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("e:/JavaProject/Thinking_in_Java/thinkingInJava/io/test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");

        for (String arg : args) {
            print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();

        print("CheckSum: " + csum.getChecksum().getValue());

        print("Reading file");
        FileInputStream fi = new FileInputStream("e:/JavaProject/Thinking_in_Java/thinkingInJava/io/test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());  //Checksum类两种校验和:Adler32(更快)和CRC32(慢一些但更准确)
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            print("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.write(x);
            }
        }

        if (args.length == 1) {
            print("Checksum: " + csumi.getChecksum().getValue());
        }
        bis.close();

        ZipFile zf = new ZipFile("e:/JavaProject/Thinking_in_Java/thinkingInJava/io/test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            print("File: " + ze2);
        }
    }
}
