package interviewTest;

import java.util.ArrayList;
import java.util.Scanner;

public class Bottom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scan.hasNextInt()){
            int temp = scan.nextInt();
            if(temp != 0) {
                arrayList.add(temp);
            }
            else{
                break;
            }
        }

        for(int i = 0; i < arrayList.size(); i++){
            howMany(arrayList.get(i));
        }
    }

    public static void howMany(int n){
        int count = 0;
        int last = n;
        int get = 0;
        while(true){
            int temp = last + get;
            get = temp / 3;
            last = temp % 3;
            count += get;
            if(get + last == 2){
                count++;
                break;
            }
            if(get + last < 2){
                break;
            }
        }
        System.out.println(count);
    }
}
