package thinkingInJava.gui;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * 任务提交给SwingUtilities.invokeLater()来实现这种方式
 * 这种方式会通过事件分发线程将任务放置到   待执行事件队列中。
 */
public class SubmitLabelManipulationTask {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        final JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(600, 300);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                label.setText("Hey! This is Different!");
            }
        });
    }
}
