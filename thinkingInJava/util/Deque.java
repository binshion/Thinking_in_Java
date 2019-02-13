package thinkingInJava.util;

import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T e) {
        deque.addFirst(e);
    }

    public void addLast(T e) {
        deque.addLast(e);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return deque.toString();
    }

    public T get(int index){
        return deque.get(index);
    }

    public T remove(int index) {
        return deque.remove(index);
    }
}
