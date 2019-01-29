
public class Test {
    public Test(){

    }
    
    public Test(int a){
        System.out.println(a);
    }
    public static void main(String[] args){
        Test t = new Test();
        byte value = 0;
        byte b = s(value);
        System.out.println(b);

    }

    public static byte s(byte a) {
        return ++a;
    }
}
