package thinkingInJava.gui;

import javax.swing.*;
import java.awt.*;

import static thinkingInJava.util.SwingConsole.*;

public class Button1 extends JFrame {
    private JButton b1 = new JButton("Button1"),
                b2 = new JButton("Button2");

    public Button1() {
        setLayout(new FlowLayout());  //先给出一个新的布局管理器。FlowLayout 使得控件可以在窗体上从左到右、上到下连续均匀分布
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        run(new Button1(), 600, 300);
    }
}
