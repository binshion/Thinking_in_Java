package thinkingInJava;

class Plate{
    Plate(){
        System.out.println("Plate1");
    }
    Plate(int i){
        System.out.println("Plate2");
    }

    void print(){
        System.out.println("print1");
    }
}

public class PlaceSeeting extends Plate{
    PlaceSeeting(){
        super(2);
        System.out.println("PlaceSeeting");
    }

    void print(){
        System.out.println("print2");
    }

    public static void main(String[] args) {
        PlaceSeeting x = new PlaceSeeting();
        x.print();
    }
}

