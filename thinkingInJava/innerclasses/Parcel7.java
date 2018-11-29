package thinkingInJava.innerclasses;

/**
 * Returning an instance of an anonymous inner class.
 * 匿名内部类，直接生成，和线程的使用类似
 * 创建一个继承自Contents的匿名类的对象。通过
 * new表达式返回的引用被自动向上转型为对Contents的引用。
 *
 * 完整形式见Parcel7b.java
 */
public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            private int i = 11;
            public int value() {
                return i;
            }
        };  //Semicolon required in this case 注意此处需要加分号;
    }

    public static void main(String[] args){
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
