import org.w3c.dom.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.GVTTreeRendererAdapter;
import org.apache.batik.swing.gvt.GVTTreeRendererEvent;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.apache.batik.swing.svg.GVTTreeBuilderAdapter;
import org.apache.batik.swing.svg.GVTTreeBuilderEvent;

public class Menu {

    public JMenuBar menuBar;

    // The SVG canvas.
    public static JSVGCanvas svgCanvas = new JSVGCanvas();


    public Menu(){
        menuBar = new JMenuBar();
    }

    public void create(){
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem newItem = new JMenuItem("New File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(exitItem);

        class LoadListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                JFileChooser chooser = new JFileChooser();
                JFrame f = new JFrame();
                int res = chooser.showSaveDialog(f);
                f.dispose();
                if (res == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    Test.fileTxt.setText("Here is your path's file : " + file.toString());
                    try {
                        svgCanvas.setURI(file.toURL().toString());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        ActionListener newList = new LoadListener();
        newItem.addActionListener(newList);

        class LoadListener1 implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        }
        ActionListener exitList = new LoadListener1();
        exitItem.addActionListener(exitList);









        // Set the JSVGCanvas listeners.
        svgCanvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter() {
            public void documentLoadingStarted(SVGDocumentLoaderEvent e) {
                Test.label.setText("Document Loading...");
            }
            public void documentLoadingCompleted(SVGDocumentLoaderEvent e) {
                Test.label.setText("Document Loaded.");
            }
        });

        svgCanvas.addGVTTreeBuilderListener(new GVTTreeBuilderAdapter() {
            public void gvtBuildStarted(GVTTreeBuilderEvent e) {
                Test.label.setText("Build Started...");
            }
            public void gvtBuildCompleted(GVTTreeBuilderEvent e) {
                Test.label.setText("Build Done.");
                Test.frame.pack();
            }
        });

        svgCanvas.addGVTTreeRendererListener(new GVTTreeRendererAdapter() {
            public void gvtRenderingPrepare(GVTTreeRendererEvent e) {
                Test.label.setText("Rendering Started...");
            }
            public void gvtRenderingCompleted(GVTTreeRendererEvent e) {
                Test.label.setText("");
            }
        });
    }
}
