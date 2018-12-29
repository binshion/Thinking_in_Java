package thinkingInJava.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 适配器惯用法，当你有一个接口并需要另一个接口时，
 * 编写适配器就可以解决问题。
 * 示例：在默认的前向迭代器基础上，添加产生反向迭代器的能力
 */
public class AdapterMethodIdiom {
    public static void main(String[] args){
        ReversibleArrayList<String> ral = new ReversibleArrayList<String>(
                Arrays.asList("Health beauty intelligence".split(" "))
        );

        for(String s : ral) {
            System.out.println(s + " ");
        }

        System.out.println();

        //ral.reversed() 提示迭代器不能使用foreach
        Iterator it = ral.reversed();
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }
    }
}

/**
 * 描述：Iterator的next方法重写，倒序查找即可
 *      hasNext方法取容器的size() - 1,初始值
 * @param <T>
 */
class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterator<T> reversed() {
        return new Iterator<T>() {
            int current = size() - 1;

            @Override
            public boolean hasNext() {
                return current > -1;
            }

            @Override
            public T next() {
                return get(current--);
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
