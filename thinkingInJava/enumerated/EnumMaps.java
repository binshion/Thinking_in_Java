package thinkingInJava.enumerated;

import java.util.EnumMap;
import java.util.Map;

import static thinkingInJava.enumerated.AlarmPoints.*;
import static thinkingInJava.util.Print.*;

/**
 * 命令设计模式使用EnumMap
 * 命令模式：
 *  首先需要一个只有单一方法的接口，然后从
 *  该接口实现具有各自不同的行为的多个子类。
 */
public class EnumMaps {
    public static void main(String[] args){
        EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                print("Kitchen fire!");
            }
        });

        em.put(BATHROOM, new Command() {
            @Override
            public void action() {
                print("Bathroom alert!");
            }
        });

        for (Map.Entry<AlarmPoints,Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
}

interface Command {
    void action();
}
