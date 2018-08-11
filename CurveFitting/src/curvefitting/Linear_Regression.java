/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curvefitting;

/**
 *
 * @author Night-Fury
 */

import java.util.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
//import org.apache.commons.math3.stat.regression.SimpleRegression;
//import org.math.plot.Plot2DPanel;
//import org.math.plot.plotObjects.BaseLabel;

public class Linear_Regression 
{
	public static int Continue;
	
	public static Scanner Num_Scanner = new Scanner(System.in);

	public static void Linear_Regression() throws IOException
	
	{
		
int i , n; 
		
        Scanner input;
        
        input = new Scanner(System.in);
		
		System.out.println("Enter The Number Of Points: ");
		n = input.nextInt();

		double x[] = new double [n];
		double y[] = new double [n];
		
		
		System.out.println("Enter The Points (X,Y): ");
		for ( i = 0; i < n; i++) 
		{
			x[i] = input.nextDouble();
			y[i] = input.nextDouble();
		}
		
		
		SimpleRegression simpleRegression = new SimpleRegression(true);
	
		for (i = 0; i < x.length;i++)
			simpleRegression.addData(x[i], y[i]);
        
                
        Plot2DPanel plot = new Plot2DPanel();
        
        JTextArea result = new JTextArea();
        
        double yc[] = new double [y.length];
        
        for (i = 0 ;i < x.length ; i++ )
            yc[i] = simpleRegression.predict(x[i]);
        
        plot.addLegend("South");
        plot.addScatterPlot("Points", x,y);
        plot.addLinePlot("Regression", x,yc);
        
        BaseLabel base = new BaseLabel("Regression", Color.RED, 0.5,1.1);
        plot.addPlotable(base);
        
       result.setBackground(Color.WHITE);
       
       result.append("\n\n\t\tNumber Of Known Point Sets: "+ n);
       result.append("\n\t\tSlope = " + simpleRegression.getSlope());
       result.append("\n\t\tIntercept = " + simpleRegression.getIntercept());
       result.append("\n\n\t\tThe Equation of The Regression Line: ");
       
        if (simpleRegression.getIntercept() < 0) {
           
            result.append("\n\t\ty  =  " +simpleRegression.getSlope()+" *x  " + simpleRegression.getIntercept());
        }
       
       else
            result.append("\n\t\ty  =  " +simpleRegression.getSlope()+" *x  + " + simpleRegression.getIntercept());
       
        result.append("\n\n");
       
      
        JFrame frame = new JFrame("Curve Fitting");
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(1000,1000);
        
        frame.add(plot,BorderLayout.CENTER);
        
        frame.add(result,BorderLayout.SOUTH);
        
        frame.setVisible(true);
        
        CurveFitting.Selection();
        
	}
	
}
