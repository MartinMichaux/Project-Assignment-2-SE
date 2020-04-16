import javax.swing.*;
import java.awt.*;

public class Test {
    public static JTextArea fileTxt;
    public static JTextArea txt;
    public static JLabel label;
    public static JFrame frame;
    public static JPanel panel;

    public static void main(String []args){
        frame = new JFrame("test");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        Menu menu = new Menu();
        menu.create();
        panel.add(menu.menuBar,BorderLayout.NORTH);

        txt = new JTextArea("Here will come the SVG graph");
        fileTxt = new JTextArea("Here will come your path's file.");
        label = new JLabel("Welcome to the Assignment 2 !!!");
        panel.add(txt,BorderLayout.CENTER);
        panel.add(fileTxt,BorderLayout.SOUTH);
        panel.add(label,BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}
