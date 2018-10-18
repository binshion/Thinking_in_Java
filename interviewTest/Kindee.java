package interviewTest;

public class Kindee {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b= new StringBuffer("B");
        operat(a, b);
        System.out.println(a+","+b);
    }

    public static void operat(StringBuffer x, StringBuffer y){
        x.append(y);
        y=x;
    }
}
