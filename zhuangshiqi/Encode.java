package zhuangshiqi;

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
        System.out.println(newFilename);
        System.out.println(fi);
    }
}
