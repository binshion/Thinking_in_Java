package thinkingInJava.gui;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxes extends JFrame {
    private JTextArea t = new JTextArea(6, 15);
    private JCheckBox
        cb1 = new JCheckBox("Check Box 1"),
        cb2 = new JCheckBox("Check Box 2"),
        cb3 = new JCheckBox("Check Box 3");

    public CheckBoxes() {
        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trace("1", cb1);
            }
        });
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trace("2", cb2);
            }
        });
        cb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trace("3", cb3);
            }
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(t));
        add(cb1);
        add(cb2);
        add(cb3);
    }

    private void trace(String b, JCheckBox cb) {
        if (cb.isSelected()) {
            t.append("Box " + b + " Set\n");
        } else {
            t.append("Box " + b + " Cleared\n");
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new CheckBoxes(), 500, 400);
    }
}
