import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OriginalScreen implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        Test.frame.setSize(Menu.svgSize);
    }
}