package com.mycompany.fractals;

public class FractalCalc {

    private static final int THRESHOLD = 63;

    public static int mandelbrot(double locR, double locI) {
        Complex z = new Complex(0, 0);
        Complex c = new Complex(locR, locI);

        int count = 0;
        while (z.magnitude() < 2.0 && count < THRESHOLD) {
            z = z.multiply(z);
            z = z.add(c);
            count++;
        } // while
        return count;
    }
    
    public static int julia(double locR, double locI) {
        Complex z = new Complex(locR, locI);
        Complex c = new Complex(-1.2, 0.2);

        int count = 0;
        while (z.magnitude() < 2.0 && count < THRESHOLD) {
            z = z.multiply(z);
            z = z.add(c);
            count++;
        } // while
        return count;
    }

    public static double uMap(int x) {
        /*
        to preserve square shape,
        distance between max and min
        should be the same for uMap and vMap
        */
        double max = 0.4;
        double min = -0.1;
        double xMax = 511;
        double xMin = 0;

        double result = min + (max - min) * (x - xMin) / (xMax - xMin);

        return result;
    } //uMap(int)

    public static double vMap(int y) {
        double max = 0;
        double min = -0.5;
        double yMax = 511;
        double yMin = 0;

        double result = min + (max - min) * (y - yMin) / (yMax - yMin);

        return result;
    }

}
