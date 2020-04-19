import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FullScreen implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        Test.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Test.frame.setUndecorated(true);
    }
}