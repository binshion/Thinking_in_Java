package stream;

import java.io.*;

public class TestStream {
    public static void main(String[] args){
        File file = new File("E:/test.txt");
        File file1 = new File("E:/test1.txt");
        try(FileReader fr = new FileReader(file);
                FileWriter fw = new FileWriter(file1);
                BufferedReader br = new BufferedReader(fr);
                BufferedWriter bw = new BufferedWriter(fw);){
            String[] all = new String[(int) file.length()];



        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
