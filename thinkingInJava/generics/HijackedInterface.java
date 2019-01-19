package thinkingInJava.generics;

/**
 * 窄化进行Cat类型比较
 * 但是基类确认了ComparablePet参数，其他实现类都不能与ComparablePet之外的任何对象比较
 * class Cat extends ComparablePet implements Comparable<Cat> 编译将失败
 */
class Cat extends ComparablePet {
    public int compareTo(Cat o) {
        return 0;
    }
}
