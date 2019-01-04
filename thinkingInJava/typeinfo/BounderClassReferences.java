package thinkingInJava.typeinfo;

/**
 * 通配符和extends相结合，限定为某个类型，或该类型的任何子类型
 * 或者超类Class<? super ss>
 */
public class BounderClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> bounder = int.class;
        bounder = double.class;
        bounder = Number.class;
    }
}
