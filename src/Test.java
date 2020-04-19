import javax.swing.*;
import java.awt.*;

public class Test {
    public static JLabel label;
    public static JFrame frame;
    public static JPanel panel;

    public static void main(String []args){
        frame = new JFrame();
        frame.setSize(450,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        Menu menu = new Menu();
        menu.create();
        panel.add(menu.menuBar,BorderLayout.NORTH);

        label = new JLabel("Welcome to the Assignment 2 ! Choose a SVG file to load.");
        label.setFont(new Font("Courier New", Font.ITALIC, 13));
        label.setForeground(Color.white);
        panel.setBackground(Color.pink);
        panel.add(label,BorderLayout.CENTER);

        frame.add(panel);

        Dimension dimemsion = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dimemsion.width/2-frame.getSize().width/2, dimemsion.height/2-frame.getSize().height/2);
        frame.setVisible(true);

    }
}
