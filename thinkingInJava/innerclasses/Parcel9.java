package thinkingInJava.innerclasses;

/**
 * 对匿名内部类进行初始化
 */
public class Parcel9 {
    //使用一个在其外部定义的对象，参数引用设置为final
    public Destination destination(final String dest) {
        return new Destination() {
          private String label = dest;
          public String readLabel() {
              return label;
          }
        };
    }

    public static void main(String[] args){
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Binshion");
    }
}
