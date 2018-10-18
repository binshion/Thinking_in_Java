package factory;

public class Test {
    public static void main(String[] args) {
        AnimalFactory f = new DogFactory();
        Animal a = f.createAnimal();
        a.eat();
    }
}
