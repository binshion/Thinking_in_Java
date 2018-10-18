package work;

import java.util.ArrayList;
import java.util.Scanner;

public class DrinkBotton {
    /**
     * 3个空酒瓶换1瓶酒
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<> ();

        while (scan.hasNextInt()){
            int emptyNum = scan.nextInt();
            if(emptyNum == 0) break;
            arr.add(emptyNum);
        }
        for(int i = 0; i < arr.size(); i++) {
            int s = getNew(0, 0, arr.get(i));
            System.out.println(s);
        }
    }

    public static int getNew(int count, int get, int last) {
       while ((get + last) > 2) {
           int temp = get + last;
           get = temp / 3;
           last = temp % 3;
           count += get;
       }

       if((get + last) == 2){
           count++;
       }
       return count;
    }
}
