package com.mycompany.fractals;

/**
 * @author Kaelin Miller
 * @version 4/12/2020
 */
public class Complex {
    final double real;
    final double imaginary;
    
    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    } //Complex(double, double)
    
    public Complex add(Complex c){
        return new Complex(this.real + c.real, this.imaginary + c.imaginary);
    } //add(Complex)
    
    public Complex multiply(Complex c){
        double first = this.real * c.real;
        double outside = this.real * c.imaginary;
        double inside = this.imaginary * c.real;
        double last = this.imaginary * c.imaginary;
        
        return new Complex(first - last, outside + inside);
    } //multiply(Complex)
    
    public double magnitude(){
        return Math.sqrt(this. real * this.real + this.imaginary * this.imaginary);
    } //magnitude()
    
    @Override
    public String toString(){
        if (this.imaginary < 0){
            return this.real + " - " + Math.abs(this.imaginary) + "i";
        }
        else{
            return this.real + " + " + this.imaginary + "i";
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
