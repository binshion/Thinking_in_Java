package thinkingInJava.containers;

import java.util.LinkedList;
import java.util.Stack;

import static thinkingInJava.util.Print.*;

/**
 * Stack的使用。目前栈不是用Vector来构建的，而是继承了Vector.
 * 因此对Vector的执行操作，都能对Stack执行，例如elementAt().
 * 如果需要栈的行为，应该使用LinkedList模拟出栈和入栈
 */
public class Stacks {
    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        print("stack = " + stack);

        //treating a stack as a Vector
        stack.addElement("The last line");
        print("element 5 = " + stack.elementAt(5));
        print("popping elements:");
        while (!stack.empty()) {
            printnb(stack.pop() + " ");
        }

        //using a LinkedList as a Stack:
        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values()) {
            lstack.addFirst(m.toString());
        }
        print("lstack = " + lstack);
        while (!lstack.isEmpty()) {
            printnb(lstack.removeFirst() + " ");
        }
    }
}

enum Month {JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
            JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
            }
