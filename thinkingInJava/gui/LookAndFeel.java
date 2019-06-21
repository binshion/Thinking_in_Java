package thinkingInJava.gui;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * java thinkingInJava.gui.LookAndFeel "cross"
 * java thinkingInJava.gui.LookAndFeel "system"
 * java thinkingInJava.gui.LookAndFeel "motif"
 */
public class LookAndFeel extends JFrame {
    private String[] choices = "Eeny Meeny Minnie Micky Moe Larry Curly".split(" ");
    private Component[] samples = {
            new JButton("JButton"),
            new JTextField("JTextField"),
            new JLabel("JLabel"),
            new JCheckBox("JCheckBox"),
            new JList(choices),
    };

    public LookAndFeel() {
        super("Look And Feel");
        setLayout(new FlowLayout());

        for (Component component : samples) {
            add(component);
        }
    }

    private static void usageError() {
        System.out.println("Usage:LookAndFeel [cross|system|motif]");
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            usageError();
        }
        if (args[0].equals("cross")) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args[0].equals("system")) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (args[0].equals("motif")) {
            try {
                UIManager.setLookAndFeel("com.sun.java." + "swing.plaf.motif.MotifLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            usageError();
        }

        //Note the look & feel must be set before
        //any components are created
        SwingConsole.run(new LookAndFeel(), 300, 300);
    }
}
