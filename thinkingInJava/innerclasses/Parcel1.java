package thinkingInJava.innerclasses;

//创建内部类

public class Parcell {
    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;
        Destination(String whrTo) {
            label = whrTo;
        }

        String readLabel() {
            return label;
        }
    }

    //在Parcell中使用内部类就像使用其他类一样
    public void ship(String dest) {
        Contents contents = new Contents();
        Destination destination = new Destination(dest);
        System.out.println(destination.readLabel());
    }

    public static void main(String[] args){
        Parcell parcell = new Parcell();
        parcell.ship("Binshion the Great!");
    }
}
