package thinkingInJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static thinkingInJava.util.SwingConsole.*;

/**
 * 使用匿名内部类方式更方便，尤其是对每个监听器类只使用一个实例的时候更是如此。
 */
public class Button2 extends JFrame {
    private JButton b1 = new JButton("Button 1"),
                b2 = new JButton("Button 2");

    private JTextField txt = new JTextField(10);

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    }

    private ButtonListener bl = new ButtonListener();

    public Button2() {
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(txt);
    }

    public static void main(String[] args) {
        run(new Button2(), 200, 150);
    }
}
