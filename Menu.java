import org.w3c.dom.Document;

import javax.swing.*;
import java.awt.*;
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

    public static Dimension svgSize;

    static int counter;


    public Menu(){
        menuBar = new JMenuBar();
    }

    public void create(){
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        JMenuItem fullS = new JMenuItem("Full screen size");

        ActionListener newSc = new FullScreen();
        fullS.addActionListener(newSc);
        viewMenu.add(fullS);

        JMenuItem orS = new JMenuItem("Original size");

        ActionListener newScreen2 = new OriginalScreen();
        orS.addActionListener(newScreen2);
        viewMenu.add(orS);

        JMenuItem newItem = new JMenuItem("New File");

        ActionListener newList = new LoadListener();
        newItem.addActionListener(newList);
        fileMenu.add(newItem);


        JMenuItem exitItem = new JMenuItem("Exit");

        ActionListener exitList = new LoadListener1();
        exitItem.addActionListener(exitList);
        fileMenu.add(exitItem);


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
                if(counter==0){
                    svgSize = svgCanvas.getSize();
                }
                counter++;
                //Test.frame.setSize(svgSize);
            }
        });
    }
}
