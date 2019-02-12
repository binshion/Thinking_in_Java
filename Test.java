import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {
    public Test(){}
    
    public Test(int a){
        System.out.println(a);
    }

    public static void main(String[] args){
        BigDecimal d1 = new BigDecimal("0.8000");
        BigDecimal d2 = new BigDecimal("1");
        BigDecimal d3 = d2.divide(d1, d1.scale(), RoundingMode.HALF_UP);
        System.out.println(d3);
    }
}
