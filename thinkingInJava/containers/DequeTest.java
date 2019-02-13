package thinkingInJava.containers;

import thinkingInJava.util.Deque;

import static thinkingInJava.util.Print.print;

public class DequeTest {
    static void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }

        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args){
        Deque<Integer> di = new Deque<>();
        fillTest(di);
        print(di);

        while (di.size() != 0) {
            print(di.removeFirst() + " ");
        }

        print("**********");
        fillTest(di);
        while (di.size() != 0) {
            print(di.removeLast() + " ");
        }

    }
}
