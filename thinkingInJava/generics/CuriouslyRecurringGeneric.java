package thinkingInJava.generics;

class GenericType<T> {}

/**
 * 类相当古怪地出现在它自己的基类中这一事实。
 * 我在创建一个新类，它继承自一个泛型类型，这个泛型类型接受我的泪的名字作为其参数。
 */
public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric> {}
