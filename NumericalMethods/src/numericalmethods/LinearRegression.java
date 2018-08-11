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
public class LinearRegression {
   // public double y_fit[];

    public double a,b;
    
    LinearRegression(double[] x, double[] y,int n) {
        double xsum=0,x2sum=0,ysum=0,xysum=0;
        double y_fit []=new double[n];
        for (int i=0;i<n ;i++)
        {
            xsum=xsum+x[i];                        //calculate sigma(xi)
            ysum=ysum+y[i];                        //calculate sigma(yi)
            x2sum=x2sum+Math.pow(x[i],2);             //calculate sigma(x^2i)
            xysum=xysum+x[i]*y[i];                    //calculate sigma(xi*yi)
        }
        
         a=(n*xysum-xsum*ysum)/(n*x2sum-xsum*xsum);            //calculate slope
         b =(x2sum*ysum-xsum*xysum)/(x2sum*n-xsum*xsum);            //calculate intercept
        //double y_fit[n]; 
        //an array to store the new fitted values of y
        System.out.println("S.no  x   y   y(fit)");
        System.out.println("--------------------------------------------------------------------");
        for (int i=0;i<n;i++)
        {
            y_fit[i]=a*x[i]+b;  
            System.out.println(i+"    "+x[i]+"  "+y[i]+"    "+y_fit[i]);
        }//to calculate y(fitted) at given x points
        System.out.println("The Linear fit line of this form : Y = "+a+"X + "+b);
        
    }

    
    
}
