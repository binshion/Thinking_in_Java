package thinkingInJava.generics;

/**
 * Hamster说明再次实现ComparablePet中相同的接口时可能的，但只要他们精确地相同，包括参数类型在内。
 * 但是这只是与覆盖基类中的方法相同，就像在Gecko中看到的那样。
 */
class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    public int CompareTo(ComparablePet arg) {
        return 0;
    }
}

class Gecko extends ComparablePet {
    public int compareTo(ComparablePet arg) {
        return 0;
    }
}

public class RestrictedComparablePets {
}
