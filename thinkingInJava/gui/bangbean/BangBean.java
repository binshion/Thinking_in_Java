package thinkingInJava.gui.bangbean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.TooManyListenersException;

public class BangBean extends JPanel implements Serializable {
    private int xm, ym;
    private int cSize = 20;  //Circle size
    private String text = "Bang!";
    private int fontSize = 48;
    private Color tColor = Color.RED;
    private ActionListener actionListener;

    public BangBean() {
        addMouseListener(new ML());
        addMouseMotionListener(new MML());
    }

    public int getcSize() {
        return cSize;
    }

    public void setcSize(int cSize) {
        this.cSize = cSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Color gettColor() {
        return tColor;
    }

    public void settColor(Color tColor) {
        this.tColor = tColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawOval(xm - cSize / 2, ym - cSize / 2, cSize, cSize);
    }

    //This is a unicast listener, which is the simplest from of listener management
    public void addActionListener(ActionListener l) throws TooManyListenersException {
        if (actionListener != null) {
            throw new TooManyListenersException();
        }
        actionListener = l;
    }

    public void removeActionListener(ActionListener l) {
        actionListener = null;
    }

    class ML extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Graphics g = getGraphics();
            g.setColor(tColor);
            g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
            int width = g.getFontMetrics().stringWidth(text);
            g.drawString(text, (getSize().width - width) / 2, getSize().height / 2);
            g.dispose();

            //Call the listener's method
            if (actionListener != null) {
                actionListener.actionPerformed(
                        new ActionEvent(BangBean.this, ActionEvent.ACTION_PERFORMED, null)
                );
            }
        }
    }
    class MML extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            xm = e.getX();
            ym = e.getY();
            repaint();
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
