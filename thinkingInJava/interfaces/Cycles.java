package thinkingInJava.interfaces;

/*
创建一个Cycle接口及其Unicycle, Bicycle和Tricycle实现。对
每种类型的Cycle都创建相应的工厂，然后编写的代码实现这些工厂
 */

interface Cycle {
    void draw();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    @Override
    public void draw() {
        System.out.println("Draw a Unicycle!");
    }
}

class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {
    @Override
    public void draw() {
        System.out.println("Draw a Bicycle!");
    }
}

class BicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {
    @Override
    public void draw() {
        System.out.println("Draw a Tricycle!");
    }
}

class TricycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

public class Cycles {
    public static void main(String[] args){
        draw(new TricycleFactory());
        draw(new BicycleFactory());
        draw(new UnicycleFactory());
    }

    private static void draw(CycleFactory factory) {
        Cycle cycle = factory.getCycle();
        cycle.draw();
    }
}
