package thinkingInJava.innerclasses;

public interface ClassInInterface {
    void howgdy();

    class Test implements ClassInInterface {
        @Override
        public void howgdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howgdy();
        }
    }
}
