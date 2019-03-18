package thinkingInJava.enumerated.menu;

import static thinkingInJava.enumerated.menu.Food.*;

public class TypeOfFood {
    public static void main(String[] args){
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
    }
}
