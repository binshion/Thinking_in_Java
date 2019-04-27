package thinkingInJava.io;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static thinkingInJava.util.Print.*;

/**
 * login a = login info:
 *  username: Binshion
 *  date: Sat Apr 27 16:15:48 CST 2019
 *  password: showBin
 * Recovering object at Sat Apr 27 16:15:49 CST 2019
 * login a = login info:
 *  username: Binshion
 *  date: Sat Apr 27 16:15:48 CST 2019
 *  password: null
 *
 *  transient 和Serializable一起使用
 */
public class Login implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;  //瞬时关键字

    public Login(String name, String pwd) {
        username = name;
        password = pwd;
    }

    @Override
    public String toString() {
        return "login info: \n username: " + username + "\n date: " + date + "\n password: " + password;
    }

    public static void main(String[] args) throws Exception {
        Login a = new Login("Binshion", "showBin");
        print("login a = " + a);

        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io/Login.out")
        );
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);

        //now get it back
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io/Login.out")
        );
        print("Recovering object at " + new Date());
        a = (Login) in.readObject();
        print("login a = " + a);
    }
}
