package zhuangshiqi;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

import java.net.URLEncoder;

/**
 * 转码测试
 * 原文件名： 科目余额表.xls
 * ç§ç®ä½é¢è¡¨.xls
 * 科目余额表.xls
 */
public class Encode {
    public static void main(String[] args) throws Exception{
        String filename = "科目余额表.xls";

        System.out.println("原文件名： " + filename);

        String newFilename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        String fi = new String(newFilename.getBytes("ISO-8859-1"), "UTF-8");
        String f2 = new String(newFilename.getBytes("ISO-8859-1"), "ascii");
        System.out.println("UTF-8 转ISO :" + newFilename);
        System.out.println("ISO逆向UTF8 :" + fi);
        System.out.println("URLEncoder:" + URLEncoder.encode(filename, "utf-8"));

        System.out.println(f2);

        String f3 = new String(URLEncoder.encode(filename).getBytes("utf8"), "utf8");
        System.out.println(f3);
    }
}
