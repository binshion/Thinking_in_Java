package thinkingInJava.gui.frogbean;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

class Spots {}

public class Frog {
    private int jumps;
    private Color color;
    private Spots spots;
    private boolean jmpr;

    public int getJumps() {
        return jumps;
    }

    public void setJumps(int jumps) {
        this.jumps = jumps;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Spots getSpots() {
        return spots;
    }

    public void setSpots(Spots spots) {
        this.spots = spots;
    }

    public boolean isJmpr() {
        return jmpr;
    }

    public void setJmpr(boolean jmpr) {
        this.jmpr = jmpr;
    }

    public void addActionListener(ActionListener l) {
        //...
    }

    public void removeActionListener(ActionListener l) {
        //...
    }

    public void addKeyListener(KeyListener l) {
        //...
    }

    public void removeKeyListener(KeyListener l) {
        //...
    }

    public void croak() {
        System.out.println("Ribbet!");
    }
}
