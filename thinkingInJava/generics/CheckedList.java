package thinkingInJava.generics;

import factory.Animal;
import factory.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args){
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1);

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(),
                Dog.class);

        try {
            oldStyleMethod(dogs2);
        } catch (Exception e) {
            System.out.println(e);
        }

        List<Animal> pets = Collections.checkedList(new ArrayList<Animal>(),
                Animal.class);

        pets.add(new Dog());
        pets.add(new factory.Cat());
    }
}
