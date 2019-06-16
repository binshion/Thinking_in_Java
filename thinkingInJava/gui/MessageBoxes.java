package thinkingInJava.gui;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageBoxes extends JFrame {
    private JButton[] b = {
            new JButton("Alert"),
            new JButton("Yes/No"),
            new JButton("Color"),
            new JButton("Input"),
            new JButton("3 Values")
    };
    private JTextField txt = new JTextField(15);
    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = ((JButton)e.getSource()).getText();
            if ("Alert".equals(id)) {
                JOptionPane.showMessageDialog(null, "There's a bug on you!", "Hey", JOptionPane.ERROR_MESSAGE);
            } else if ("Yes/No".equals(id)) {
                JOptionPane.showConfirmDialog(null, "or no", "choose yes", JOptionPane.YES_NO_OPTION);
            } else if ("Color".equals(id)) {
                Object[] options = {"Red", "Green"};
                int sel = JOptionPane.showOptionDialog(null, "Choose a Color", "Warning", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                if(sel != JOptionPane.CLOSED_OPTION) {
                    txt.setText("Color Selected: " + options[sel]);
                }
            } else if ("Input".equals(id)) {
                String val = JOptionPane.showInputDialog("How many fingers do you see?");
                txt.setText(val);
            } else if ("3 Values".equals(id)) {
                Object[] selections = {"First", "Second", "Third"};
                Object val = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.INFORMATION_MESSAGE,
                        null, selections, selections[0]);

                if (val != null) {
                    txt.setText(val.toString());
                }
            }
        }
    };

    public MessageBoxes() {
        setLayout(new FlowLayout());
        for (int i = 0; i < b.length; i++) {
            b[i].addActionListener(al);
            add(b[i]);
        }

        add(txt);
    }

    public static void main(String[] args) {
        SwingConsole.run(new MessageBoxes(), 1000, 800);
    }
}
