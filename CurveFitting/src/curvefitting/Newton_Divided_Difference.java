package curvefitting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Night-Fury
 */
import java.util.Scanner;

public class Newton_Divided_Difference 
{
	
	public static double[] x = new double[100];
	public static double[] y = new double[100];
	public static double[] p = new double[100];
    public static int n,i,j=1;
    public static double f1=1,f2=0;
	public static double f,k;
	
	public static Scanner Num_Scanner = new Scanner(System.in);
	
	public static void Newton_Divided_Difference()
	{
		
	    System.out.println("Enter The Number Of Observations: \n");
	    n = Num_Scanner.nextInt();
	 
	    System.out.println("\nEnter The Different Values Of X: \n");
	    for (i=1;i<=n;i++)
	        x[i] = Num_Scanner.nextDouble();
	 
	    System.out.println("\nThe Corresponding Values Of Y Are: \n");
	    for (i=1;i<=n;i++)
	        y[i] = Num_Scanner.nextDouble();
	 
	    f=y[1];
	    System.out.println("\nEnter The Value Of 'K' in f(K) You Want To Evaluate:\n");
	    k = Num_Scanner.nextInt();
	    
	    Calculation();
	    Print();
    
	}
	
	public static void Calculation()
	{
		do
	    {
	        for (i=1;i<=n-1;i++)
	        {
	            p[i] = ((y[i+1]-y[i])/(x[i+j]-x[i]));
	            y[i]=p[i];
	        }
	        f1=1;
	        for(i=1;i<=j;i++)
	            {
	                f1*=(k-x[i]);
	            }
	        f2+=(y[1]*f1);
	        n--;
	        j++;
	    }
	 
	    while(n!=1);
	    f+=f2;
	}
	
	public static void Print()
	{
		System.out.println("\nf("+k+") = "+ f);
	}

}

