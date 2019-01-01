package thinkingInJava.exceptions;

class BaseballException extends Exception {}

class Foul extends BaseballException {}

class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}

    public void event() throws BaseballException {}

    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}

class RainedOut extends Exception {}

class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut, BaseballException {}

    public StormyInning(String s) throws RainedOut, BaseballException {}

    //重写方法时可以抛出子类异常
    @Override
    public void atBat() throws PopFoul {

    }

    //父类没有这个异常，也可以抛
    @Override
    public void rainHard() throws RainedOut {

    }

    //可以选择不抛出任何异常，即使父类抛出了
    @Override
    public void event(){
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
