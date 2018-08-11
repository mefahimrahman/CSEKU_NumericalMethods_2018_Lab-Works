package Numerical_Methods;

import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

public class Linear_Regression 
{
	
//	public static double[] x = new double[100];
//	public static double[] y = new double[100];
//	public static double y1,a,b,flag1=0,flag2=0,meanx,meany,sum=0,sum1=0;
//    public static int i,n;
	public static int Continue;
	
	public static Scanner Num_Scanner = new Scanner(System.in);

	public static void Linear_Regression() throws IOException
	
	{
		
//	    System.out.println("Enter The Number Of Points : \n");
//	    n = Num_Scanner.nextInt();
//	    System.out.println("\nEnter The Values Of X : \n");
//	    for(i=1;i<=n;i++)
//	    {
//	        x[i] = Num_Scanner.nextDouble();
//	        flag1=flag1+x[i];
//	    }
//	    System.out.println("\nEnter The Values Of Y : \n");
//	    for(i=1;i<=n;i++)
//	    {
//	        y[i] = Num_Scanner.nextDouble();
//	        flag2=flag2+y[i];
//	    }
//	    
//	    Calculation();
//	    Print();
//		
//	}
//	
//	public static void Calculation()
//	{
//		meanx=flag1/n;
//	    meany=flag2/n;
//	    for(i=1;i<=n;i++)
//	    {
//	        sum=sum+(x[i]-meanx)*(y[i]-meany);
//	        sum1=sum1+(x[i]-meanx)*(x[i]-meanx);
//	    }
//	    a=sum/sum1;
//	    b=meany-a*meanx;
//	}
//	
//	public static void Print()
//	{
//		System.out.println("\nRegression Equation Y = "+b+" + ("+a+")X");
//	}
		
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
        
        Main_Class.Selection();
        
	}
	
}
