package thinkingInJava.gui.jnlp;

import javax.jnlp.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;

public class JnlpFileChooser extends JFrame {
    private JTextField fileName = new JTextField();
    private JButton open = new JButton("Open"),
        save = new JButton("Save");
    private JEditorPane ep = new JEditorPane();
    private JScrollPane jsp = new JScrollPane();
    private FileContents fileContents;

    public JnlpFileChooser() {
        JPanel p = new JPanel();
        open.addActionListener(new OpenL());
        p.add(open);

        save.addActionListener(new SaveL());
        p.add(save);

        jsp.getViewport().add(ep);
        add(jsp, BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);
        fileName.setEditable(false);
        p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(fileName);
        add(p, BorderLayout.NORTH);
        ep.setContentType("text");
        save.setEnabled(false);
    }

    class OpenL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FileOpenService fs = null;
            try {
                fs = (FileOpenService)ServiceManager.lookup("javax.jnlp.FileOpenService");
            } catch (UnavailableServiceException e1) {
                throw new RuntimeException(e1);
            }

            if (fs != null) {
                try {
                    fileContents = fs.openFileDialog(".", new String[]{"txt", "*"});
                    if (fileContents == null) {
                        return;
                    }
                    fileName.setText(fileContents.getName());
                    ep.read(fileContents.getInputStream(), null);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                save.setEnabled(true);
            }
        }
    }

    class SaveL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FileSaveService fs = null;
            try {
                fs = (FileSaveService)ServiceManager.lookup("javax.jnlp.FileSaveService");
            } catch (UnavailableServiceException e1) {
                throw new RuntimeException(e1);
            }

            if (fs != null) {
                try {
                    fileContents = fs.saveFileDialog(".", new String[]{"txt"}, new ByteArrayInputStream(ep.getText().getBytes()), fileContents.getName());
                    if (fileContents == null) {
                        return;
                    }
                    fileName.setText(fileContents.getName());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        JnlpFileChooser fc = new JnlpFileChooser();
        fc.setSize(400, 300);
        fc.setVisible(true);
    }
}
