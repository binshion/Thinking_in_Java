package thinkingInJava.enumerated;

import static thinkingInJava.util.Print.*;

enum LikeClasses {
    WINKEN {
        void behavior() {
            print("Behavior1");
        }
    },
    BLINKEN {
        void behavior() {
            print("Behavior2");
        }
    },
    NOD {
        void behavior() {
            print("Behavior3");
        }
    };

    abstract void behavior();
}

/**
 * 编译发现每个enum元素都是一个LikeClass类型的static final实例
 * 由于static实例无法访问外部类的非static元素或方法。
 */
public class NotClasses {
//    void f1(LikeClasses.WINKEN instance) {}

}
