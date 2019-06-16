package thinkingInJava.gui;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleMenus extends JFrame {
    private JTextField t = new JTextField(15);
    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            t.setText(((JMenuItem)e.getSource()).getText());
        }
    };

    private JMenu[] menus = {
            new JMenu("Winken"),
            new JMenu("Blinken"),
            new JMenu("Nod")
    };
    private JMenuItem[] items = {
            new JMenuItem("Fee"),
            new JMenuItem("Fi"),
            new JMenuItem("Fo"),
            new JMenuItem("Zip"),
            new JMenuItem("Zap"),
            new JMenuItem("Zot"),
            new JMenuItem("Olly"),
            new JMenuItem("Oxen"),
            new JMenuItem("Free")
    };

    public SimpleMenus() {
        for (int i = 0; i < items.length; i++) {
            items[i].addActionListener(al);
            menus[i % 3].add(items[i]);
        }

        JMenuBar mb = new JMenuBar();
        for (JMenu jm : menus) {
            mb.add(jm);
        }
        setJMenuBar(mb);
        setLayout(new FlowLayout());
        add(t);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SimpleMenus(), 1000, 800);
    }
}
