package thinkingInJava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象进入和离开方法的地点。这些正是编译器在编译期执行
 * 类型检查并插入转型代码的地点
 * @param <T>
 */
public class FilledListMaker<T> {
    //编译器无法知道有关create()中T的任何信息，
    //但可以在编译期确保放置到result的对象具有T类型
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<T>();
        for(int i = 0; i < n; i++) {
            result.add(t);
        }

        return result;
    }

    public static void main(String[] args){
        FilledListMaker<String> stringMaker =
                new FilledListMaker<>();

        List<String> list = stringMaker.create("Hello", 5);

        System.out.println(list);
    }
}
