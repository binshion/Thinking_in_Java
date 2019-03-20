package thinkingInJava.enumerated;

import java.util.EnumSet;

import static thinkingInJava.util.Print.*;

public class CarWash {
    public enum Cycle {
        UNDERBODY {
            @Override
            void action() {
                print("Spraying the underbody");
            }
        },
        WHEELWASH {
            @Override
            void action() {
                print("Washing the wheels");
            }
        },
        PREWASH {
            @Override
            void action() {
                print("Loosening the dirt");
            }
        },
        BASIC {
            @Override
            void action() {
                print("The basic wash");
            }
        },
        HOTWAX {
            @Override
            void action() {
                print("Applying hot wax");
            }
        },
        RINSE {
            @Override
            void action() {
                print("Rinsing");
            }
        },
        BLOWDRY {
            @Override
            void action() {
                print("Blowing dry");
            }
        };

        abstract void action();
    }

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);
    public void add(Cycle cycle) {
        cycles.add(cycle);
    }
    public void washCar() {
        for (Cycle c : cycles) {
            c.action();
        }
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args){
        CarWash wash = new CarWash();
        print(wash);

        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY);  //测试重复是否会插入
        wash.add(Cycle.RINSE);
        wash.add(Cycle.HOTWAX);
        print(wash);
        wash.washCar();  //输出次序决定于enum实例定义时的次序
    }
}
