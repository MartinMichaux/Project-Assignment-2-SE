import javax.swing.*;
import java.awt.*;

public class Test {
    public static JLabel label;
    public static JFrame frame;
    public static JPanel panel;

    public static void main(String []args){
        frame = new JFrame("SVG File Reader");
        frame.setSize(340,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        Menu menu = new Menu();
        menu.create();
        panel.add(menu.menuBar,BorderLayout.NORTH);

        label = new JLabel("Welcome to the Assignment 2 ! Choose a SVG file to load.");
        panel.add(label,BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}
