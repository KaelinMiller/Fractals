package com.mycompany.fractals;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Simple extends JFrame {
    
    private static final int SIMPLE_WIDTH = 512;
    private static final int SIMPLE_HEIGHT = 512;
    private static final String SIMPLE_TITLE = "Simple";
    
    public Simple(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIMPLE_WIDTH, SIMPLE_HEIGHT);
        this.setTitle(SIMPLE_TITLE);
        
        Container pane = this.getContentPane();
        
        SimpleBitmap panel = new SimpleBitmap();
        pane.add(panel);
        
        this.setVisible(true);
    } //Simple()
    
    public static void main(String[] args){
        Simple simple = new Simple();
    }
}
