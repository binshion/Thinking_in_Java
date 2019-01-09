package thinkingInJava.generics;

import java.util.ArrayList;

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int IDnumber, String desc, double price) {
        id = IDnumber;
        description = desc;
        this.price = price;

        System.out.println(toString());
    }

    public String toString() {
        return id + ": " + description + ", price: ￥" + price;
    }
}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, )
    }
}

/**
 * 构建模型：零售店，由走廊、货架和商品构成
 */
public class Store {
}
