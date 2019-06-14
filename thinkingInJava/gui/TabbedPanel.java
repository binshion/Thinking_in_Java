package thinkingInJava.gui;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TabbedPanel extends JFrame {
    private String[] flavors = {
            "Chocolate", "Strawberry",
            "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge",
            "Rum Raisin",
            "Praline Cream",
            "Mud Pie"
    };
    private JTabbedPane tabs = new JTabbedPane();
    private JTextField txt = new JTextField(20);

    public TabbedPanel() {
        int i = 0;
        for (String flavor : flavors) {
            tabs.addTab(flavors[i], new JButton("Tabbed pane " + i++));
        }

        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                txt.setText("Tab selected: " + tabs.getSelectedIndex());
            }
        });

        add(BorderLayout.SOUTH, txt);
        add(tabs);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TabbedPanel(), 800, 200);
    }
}
