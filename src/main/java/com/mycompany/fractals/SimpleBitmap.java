package com.mycompany.fractals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

public class SimpleBitmap extends JPanel {

    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private BufferedImage image;

    public SimpleBitmap() {
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    } //SimpleBitmap()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        int w = this.getWidth();
        int h = this.getHeight();

        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w) / BITMAP_WIDTH, ((double) h) / BITMAP_HEIGHT);

        WritableRaster raster = this.image.getRaster();
        
        int [][] palette = new int[64][3];
        
        Color startColor = Color.MAGENTA;
        int r0 = startColor.getRed();
        int g0 = startColor.getGreen();
        int b0 = startColor.getBlue();
        
        Color endColor = Color.CYAN;
        int r1 = endColor.getRed();
        int g1 = endColor.getGreen();
        int b1 = endColor.getBlue();
        
        for( int i = 0; i < 64; i++ ) {
            double fraction = ((double) i) / 63;
            int red = (int) ((1 - fraction) * r0 + fraction * r1);
            int green = (int) ((1 - fraction) * g0 + fraction * g1);
            int blue = (int) ((1 - fraction) * b0 + fraction * b1);
            
            palette[i][0] = red; //red;
            palette[i][1] = green; //green;
            palette[i][2] = blue; //blue;            
        } // for

        for (int j = 0; j < h; j++) {
            for (int i = 0; i < w; i++) {

                double u = FractalCalc.uMap(i);
                double v = FractalCalc.vMap(j);
                
                int count = FractalCalc.julia(u, v);
                
                int[] color = {palette[count][0], palette[count][1], palette[count][2]}; 
                raster.setPixel(i, j, color);
                
            } //for
        } //for

        g2d.drawImage(image, scale, this);
    } //paintComponent
} //SimpleBitmap
