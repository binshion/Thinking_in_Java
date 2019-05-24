package thinkingInJava.concurrency.restaurant2;

import thinkingInJava.enumerated.menu.Food;

import java.util.concurrent.SynchronousQueue;

/**
 * 饭店仿真
 */
public class RestaurantWithQueues {
}

/**
 * This is geiven to the waiter, who gives it to the chef
 */
class Order {
    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final WaitPerson waitPerson;
    private final Food food;

    public Order(Customer customer, WaitPerson wp, Food food) {
        this.customer = customer;
        waitPerson = wp;
        this.food = food;
    }

    public Food item() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }

    @Override
    public String toString() {
        return "Order: " + id + " item: " + food +
                " for: " + customer +
                " served by: " + waitPerson;
    }
}

/**
 * This is what comes back from the chef
 */
class Plate {
    private final Order order;
    private final Food food;

    public Plate(Order ord, Food f) {
        order = ord;
        food = f;
    }

    public Order getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}

/**
 * 使用一个没有内部容量的阻塞队列SynchronousQueue，
 * 每个put()都必须等待一个take()，反之亦然。
 */
class Customer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;

    //Only one course at a time can be received
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    @Override
    public void run() {

    }
}

class WaitPerson {

}

class Chef {

}

class Restaurant {

}
