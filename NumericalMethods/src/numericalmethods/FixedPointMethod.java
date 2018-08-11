/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numericalmethods;

/**
 *
 * @author Night-Fury
 */
public class FixedPointMethod {
     
    public double g(double x) {
        return Math.exp(-x);
    }
    
    public double f(double x) {
        return Math.exp(-x) - x;
    }
    
    public double f_derivative(double x) {
        return -(Math.exp(-x)) - 1;
    }
    
    public void fixedPointIteration(double x0) {
        double es = 0.01;
        double ea = 100;
        double xr = x0;
        double xr_old;
        int iter = 0;
        System.out.println("         Ite.....xl.........ea");
        
        do {
            xr_old = xr;
            xr = this.g(xr_old);
            iter++;
            
            if (xr != 0) {
                ea = Math.abs(((xr - xr_old) / xr)) * 100;
            }
            
            System.out.println(String.format("%10d %10f %10f", iter, xr, ea));
            
        } while (ea > es);  
    }
    

}

