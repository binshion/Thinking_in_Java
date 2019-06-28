package thinkingInJava.gui.bangbean;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TooManyListenersException;

public class BangBeanTest extends JFrame {
    private JTextField txt = new JTextField(20);

    //During testingm report actions
    class BBL implements ActionListener {
        private int count = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            txt.setText("BangBean action " + count++);
        }
    }

    public BangBeanTest() {
        BangBean bb = new BangBean();

        try {
            bb.addActionListener(new BBL());
        } catch (TooManyListenersException e) {
            txt.setText("Too many listeners");
        }
        add(bb);
        add(BorderLayout.SOUTH, txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new BangBeanTest(), 400, 500);
    }
}
