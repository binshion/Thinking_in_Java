package thinkingInJava.enumerated.cartoons;

import thinkingInJava.util.Generator;

import java.util.Random;

/**
 * 所有enum都继承自java.lang.Enum类，不支持多重继承时，
 * 在我们创建一个新的enum可同时实现一个或多个接口
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY,
    BOB;

    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args){
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}
