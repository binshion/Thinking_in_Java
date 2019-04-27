package thinkingInJava.xml;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

import java.io.File;
import java.util.ArrayList;

public class People extends ArrayList<Person> {
    public People(String filename) throws Exception {
        //使用new File()进行转换，因为我们的Url可能被识别为错误的文件路径，转而尝试访问网络获取XML文件
        Document doc = new Builder().build(new File(filename));
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        People p = new People("E:/JavaProject/Thinking_in_Java/thinkingInJava/xml/People.xml");
        System.out.println(p);
    }
}
