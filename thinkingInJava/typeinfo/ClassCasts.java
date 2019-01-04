package thinkingInJava.typeinfo;

class Building {}

class House extends Building {}

/**
 * 使用cast()转型，对于无法使用普通转型的情况会非常有用
 */
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b;
    }
}
