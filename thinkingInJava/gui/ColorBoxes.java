package thinkingInJava.gui;

import thinkingInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ColorBoxes extends JFrame {
    private int grid = 12;
    private int pause = 50;
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public void setUp() {
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            CBox cb = new CBox(pause);
            add(cb);
            exec.execute(cb);
        }
    }

    public static void main(String[] args) {
        ColorBoxes boxes = new ColorBoxes();
        if (args.length > 0) {
            boxes.grid = new Integer(args[0]);
        }
        if (args.length > 1) {
            boxes.pause = new Integer(args[1]);
        }
        boxes.setUp();
        SwingConsole.run(boxes, 500, 400);
    }
}

class CBox extends JPanel implements Runnable {
    private int pause;
    private static Random rand = new Random();
    private Color color = new Color(0);

    public void paintComponent(Graphics g) {
        g.setColor(color);
        Dimension s = getSize();
        g.fillRect(0, 0, s.width, s.height);
    }

    public CBox(int pause) {
        this.pause = pause;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                color = new Color(rand.nextInt(0xFFFFFF));
                repaint();  //asynchronously request a paint()
                TimeUnit.MILLISECONDS.sleep(pause);
            }
        } catch (InterruptedException e) {
            //Acceptable way to exit
        }
    }
}
