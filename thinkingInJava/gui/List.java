package thinkingInJava.gui;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry",
            "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge",
            "Rum Raisin",
            "Praline Cream",
            "Mud Pie"
    };
    private DefaultListModel lItems = new DefaultListModel();
    private JList lst = new JList(lItems);
    private JTextArea t = new JTextArea(flavors.length, 20);
    private JButton b = new JButton("Add Item");
    private ActionListener bl = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(count < flavors.length) {
                lItems.add(0, flavors[count++]);
            } else {
                //Disable, since there are no more flavors left to be added to the list
                b.setEnabled(false);
            }
        }
    };
    private ListSelectionListener ll = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting()) return;
            t.setText("");
            for (Object item : lst.getSelectedValuesList()) {
                t.append(item + "\n");
            }
        }
    };
    private int count = 0;

    public List() {
        t.setEnabled(false);
        setLayout(new FlowLayout());

        Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
        lst.setBorder(brd);
        t.setBorder(brd);

        //Add the first four items to the list
        for (int i = 0; i < 4; i++) {
            lItems.addElement(flavors[count++]);
        }

        add(t);
        add(lst);
        add(b);

        //Register event listener
        lst.addListSelectionListener(ll);
        b.addActionListener(bl);
    }

    public static void main(String[] args) {
        SwingConsole.run(new List(), 250, 375);
    }
}
