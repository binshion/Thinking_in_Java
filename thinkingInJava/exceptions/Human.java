package thinkingInJava.exceptions;

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            //如果把捕获基类的子句放在前面，编译器会发现Sneeze的子句永远得不到执行，会编译错误
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }

        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            //会捕获Annoyance以及所有从它派生的异常
            System.out.println("Caught Annoyance");
        }
    }
}
