import javax.swing.*;
import java.awt.*;

public class Frame {

    private JFrame frame;
    private JPanel panel;

    private JTextArea fileTxt;

    public Frame(){
        frame = new JFrame("test");
        frame.setSize(300,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        Menu menu = new Menu();
        menu.create();
        panel.add(menu.menuBar,BorderLayout.NORTH);

        JTextArea txt = new JTextArea("Here will come the SVG graph");
        fileTxt = new JTextArea("Here is your file's path : ");
        JLabel label = new JLabel("Welcome to the Assignment 2 !!!");
        panel.add(txt,BorderLayout.CENTER);
        panel.add(fileTxt,BorderLayout.SOUTH);
        panel.add(Menu.svgCanvas);
        panel.add(label,BorderLayout.CENTER);

        frame.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextArea getFileTxt() {
        return fileTxt;
    }

    public void setFileTxt(JTextArea fileTxt) {
        this.fileTxt = fileTxt;
    }
}
