import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class LoadListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir" )+System.getProperty("file.separator"));
        JFrame f = new JFrame();
        int res = chooser.showSaveDialog(f);
        f.dispose();
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            Test.panel.add(Menu.svgCanvas, BorderLayout.CENTER);
            try {
                Menu.svgCanvas.setURI(file.toURL().toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(chooser.getSelectedFile());
    }
}
