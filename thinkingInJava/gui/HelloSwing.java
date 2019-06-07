package thinkingInJava.gui;

import javax.swing.*;

public class HelloSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");

        //setDefaultCloseOperation告诉JFrame当用户执行关闭操作时应该做些什么
        //EXIT_ON_CLOSE常量告诉它要退出程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setVisible(true);
    }
}
