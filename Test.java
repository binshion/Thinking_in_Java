import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public Test(){}
    
    public Test(int a){
        System.out.println(a);
    }

    public static void main(String[] args){
        String s = "{GL_102=false, GL_VCH_POST_CONTROL=false, GL_111=true, GL_012=true, GL_0151=true, GL_031=true, G003=false, G001=true, G010=true, GL_069=false, GL_014_1=false, GL_043=false, GL_0302=false, GL_067=0, GL_029=false, GL_047=0, GL_0155=false, GL_003=2, GL_015=false, GL_002=2, GL_014=0, GL_099=false}";
        s = s.replaceAll("}", "");
        s = s.replaceAll("\\{", "");

        Map map = new HashMap();
        String[] lists = s.split(",");
        for (int i = 0; i < lists.length; i++) {
            String[] list = lists[i].split("=");
            String key = list[0];
            String value = list[1];
            if (value.equals("true") || value.equals("false")) {
                map.put(key, Boolean.valueOf(value));
            } else {
                map.put(key, value);
            }
        }
    }
}
