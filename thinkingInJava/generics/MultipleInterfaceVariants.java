package thinkingInJava.generics;

interface Payable<T> {}

class Employees implements Payable<Employees> {}

/**
 * 不能编译，因为擦除会将Payable<Employees>和Payable<Hourly> 简化成相同的类Payable,
 * 这意味着重复实现了相同的接口
 */
//class Hourly extends Employees implements Payable<Hourly> {}

public class MultipleInterfaceVariants {
}
