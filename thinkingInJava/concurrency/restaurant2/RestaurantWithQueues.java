package thinkingInJava.concurrency.restaurant2;

import thinkingInJava.enumerated.menu.Food;

/**
 * 饭店仿真
 */
public class RestaurantWithQueues {
}

class Order {
    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final WaitPerson waitPerson;
    private final Food food;

    public Order(Customer cust, WaitPerson wp, Food food) {
        customer = cust;
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

class Plate {

}

class Customer {

}

class WaitPerson {

}

class Chef {

}

class Restaurant {

}
