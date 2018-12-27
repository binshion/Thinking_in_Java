package zhuangshiqi;

import java.util.Calendar;
import java.util.Date;

public class LastDayOfMonth {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        System.out.println(c.getTime());

        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(c.getTime());
        c.roll(Calendar.DAY_OF_MONTH, -1);

        System.out.println(c.getTime());
    }
}
