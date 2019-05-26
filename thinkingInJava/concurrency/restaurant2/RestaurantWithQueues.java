package thinkingInJava.concurrency.restaurant2;

import thinkingInJava.enumerated.menu.Course;
import thinkingInJava.enumerated.menu.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static thinkingInJava.util.Print.*;

/**
 * 饭店仿真
 */
public class RestaurantWithQueues {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, 5, 2);
        exec.execute(restaurant);

        if (args.length > 0) {  //Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            print("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
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

    public Customer(WaitPerson w) {
        waitPerson = w;
    }

    public void deliver(Plate p) throws InterruptedException {
        //Only blocks if customer is still eating the previous course:
        placeSetting.put(p);
    }

    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();

            try {
                waitPerson.placeOrder(this, food);

                //Blocks until course has been delivered
                print(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                print(this + "waiting for " + course + " interrupted");
                break;
            }
        }
        print(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customer " + id + " ";
    }
}

class WaitPerson implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();

    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    public void placeOrder(Customer cust, Food food) {
        try {
            //Shouldn't actually block because this is a LinkedBlockingQueue with no size limit
            restaurant.orders.put(new Order(cust, this, food));
        } catch (InterruptedException e) {
            print(this + " placeOrder interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until a course is ready
                Plate plate = filledOrders.take();
                print(this + "received " + plate + " delivering to " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            print(this + "interrupted");
        }
        print(this + " off duty");
    }

    @Override
    public String toString() {
        return "WaitPerson " + id + " ";
    }
}

class Chef implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random rand = new Random(47);

    public Chef(Restaurant r) {
        restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until an order appears
                Order order = restaurant.orders.take();
                Food requestedItem = order.item();

                //Time to prepare order
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(4000));
                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().filledOrders.put(plate);
            }
        } catch (InterruptedException e) {
            print(this + " interrupted");
        }
        print(this + " off duty");
    }

    @Override
    public String toString() {
        return "Chef " + id + " ";
    }
}

class Restaurant implements Runnable {
    private List<WaitPerson> waitPersons = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    private static Random rand = new Random(47);
    BlockingQueue<Order> orders = new LinkedBlockingQueue<>();

    public Restaurant(ExecutorService e, int nWaitPersons, int nChefs) {
        exec = e;
        for (int i = 0; i < nWaitPersons; i++) {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            exec.execute(waitPerson);
        }

        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //A new customer arrives: assign a WaitPerson
                WaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));
                Customer c = new Customer(wp);
                exec.execute(c);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            print("Restaurant interrupted");
        }
        print("Restaurant closing");
    }
}
