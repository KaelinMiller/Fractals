package com.mycompany.fractals;

public class FractalCalc {

    private static final int THRESHOLD = 255;

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

    public static double uMap(int x) {
        double max = 1.2;
        double min = -2;
        double xMax = 511;
        double xMin = 0;

        double result = min + (max - min) * (x - xMin) / (xMax - xMin);

        return result;
    } //uMap(int)

    public static double vMap(int y) {
        double max = 1.2;
        double min = -2;
        double yMax = 511;
        double yMin = 0;

        double result = min + (max - min) * (y - yMin) / (yMax - yMin);

        return result;
    }

}
