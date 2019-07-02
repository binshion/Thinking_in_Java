package thinkingInJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class BangBean2 extends JPanel implements Serializable {
    private int xm, ym;
    private int cSize = 20;  //Circle size
    private String text = "Bang!";
    private int fontSize = 48;
    private Color color = Color.RED;

    private ArrayList<ActionListener> actionListeners =
            new ArrayList<>();

    public BangBean2() {
        addMouseListener(new ML());
        addMouseMotionListener(new MML());
    }

    public synchronized int getcSize() {
        return cSize;
    }

    public synchronized void setcSize(int cSize) {
        this.cSize = cSize;
    }

    public synchronized String getText() {
        return text;
    }

    public synchronized void setText(String text) {
        this.text = text;
    }

    public synchronized int getFontSize() {
        return fontSize;
    }

    public synchronized void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public synchronized Color getColor() {
        return color;
    }

    public synchronized void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(xm - cSize / 2, ym - cSize / 2, cSize, cSize);
    }


}
