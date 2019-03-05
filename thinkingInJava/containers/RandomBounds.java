package thinkingInJava.containers;

import static thinkingInJava.util.Print.*;

public class RandomBounds {
    static void usage() {
        print("Usage:");
        print("\tRandomBounds lower");
        print("\tRandomBounds upper");
        System.exit(1);
    }

    public static void main(String[] args){
        if (args.length != 1) {
            usage();
        }
        if (args[0].equals("lower")) {
            while (Math.random() != 0.0) {

            }
            print("Produced 0.0!");
        } else if (args[0].equals("upper")) {
            while (Math.random() != 1.0) {

            }
            print("Produced 1.0!");
        } else {
            usage();
        }
    }
}
