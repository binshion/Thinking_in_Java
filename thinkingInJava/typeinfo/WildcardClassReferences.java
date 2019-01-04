package thinkingInJava.typeinfo;

/**
 * 使用泛化的Class引用时放松限制
 * 通配符？，表示任何事物
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
