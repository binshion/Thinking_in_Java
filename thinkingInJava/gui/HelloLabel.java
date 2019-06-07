package thinkingInJava.gui;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Swing有专有的线程来接收UI事件并更新屏幕。
 * 如果从main线程着手对屏幕进行操作，那么就可能会产生冲突和死锁。
 */
public class HelloLabel {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        label.setText("Hey! This is Different!");
    }
}
