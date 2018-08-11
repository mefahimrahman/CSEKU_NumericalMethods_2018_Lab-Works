/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numericalmethods;
import java.io.IOException;
import java.util.Scanner;
import static numericalmethods.GaussJordanElimination.test;

/**
 *
 * @author Night-Fury
 */
public class NumericalMethods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        System.out.println("#NUMERICAL METHODS IMPLEMENTATION\nEnter Your Choice:\n1. Roots Of Equation\n2. Linear System Of Equation\n3. Linear Regression\n4. Interpolation");
        System.out.println("");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        //System.out.println("");
        if(choice==1)
        {
            System.out.println("#Roots Of Equation:\n1. Bracketing Methods\n2. Open Methods");
            System.out.println("");
            Scanner sc = new Scanner(System.in);
            int ch = scan.nextInt();
            System.out.println("");
            if(ch==1)
            {
                System.out.println("#Bracketing Methods:\n1. Bisection Method\n2. False Possition Method");
                System.out.println("");
                Scanner sc1 = new Scanner(System.in);
                int ch1 = scan.nextInt();
                if(ch1 == 1)
                {
                    //Bisection Method Implements
                    BisectionMethod bm = new BisectionMethod();

                    System.out.print("\nEnter the lower Value Xl : ");
                    double Xl = sc.nextDouble();

                    System.out.print("\nEnter the upper Value Xu : ");
                    double Xu = sc.nextDouble();
                    System.out.print("\nEnter the Error Criterion Es : ");
                    double Es = sc.nextDouble();
                   // System.out.print("\nEnter the True Value for Compute the True Percent Relative Error : ");
                    //double tvalue = sc.nextDouble();
                    System.out.println("\nIter.     Xl      Xu   Xr    Ea");
                    bm.BMethod(Xl, Xu, Es);
                }
                else if(ch1 == 2)
                {
                    //False Position Method Implements
                    FalsePositionMethod fpm = new FalsePositionMethod();

                    System.out.print("\nEnter the lower Value Xi : ");
                    double Xi = sc.nextDouble();

                    System.out.print("\nEnter the upper Value Xu : ");
                    double Xu = sc.nextDouble();
                    System.out.print("\nEnter the Error Criterion Es : ");
                    double Es = sc.nextDouble();
                    System.out.print("\nEnter the True Value for Compute the True Percent Relative Error : ");
                    double tvalue = sc.nextDouble();

                    System.out.println("\nIter.         Xi           Xu          Xr          Ea");
                    fpm.FMethod(Xi, Xu, tvalue, Es);
                }
                else
                    System.out.println("Wrong Choice!!");
            }
            else if(ch==2)
            {
                System.out.println("#Open Methods:\n1. Fixed Point Iteration\n2. Newton-Raphson Method\n3. Secant Method");
                System.out.println("");
                Scanner sc2 = new Scanner(System.in);
                int ch2 = scan.nextInt();
                  if(ch2 == 1)
                    {
                        //Fixed Point Iteration
                      /*  FixedPointMethod fp = new FixedPointMethod();
            		System.out.print("Enter approximate p: ");
        	        double p0 = sc.nextDouble();
                        
                        fp.f(p0);
        	        System.out.print("Desired Tolerance: ");
        	        double tol = sc.nextDouble();
                        fp.g(tol);
        	        System.out.print("Maximum Iterations: ");
        	        int no = sc.nextInt();
        	        fp.fixedPoint(p0, tol, no);
*/                    }
                    else if(ch2 == 2)
                    {
                        //Newton-Raphson Method
                        System.out.println("Not Yet Done");
                    }
                    else if(ch2 == 3)
                    {
                        //Secant Method
                        System.out.println("Not Yet Done");
                    }
                    else {
                        System.out.println("Wrong Choice!");
                    
                }
            }
        }
        else if(choice ==2)
        {
            System.out.println("#Linear System Of Equation\n1. Gauss Elimination\n2. Gauss Jordan Elimination\n3. Gauss Sneidel Elimination");
            int cho = scan.nextInt();
            //Inner Choice between three
            if(cho==1)
            {
                        //Gauss Elemination
                        /** Make an object of GaussianElimination class **/
                        GaussianElimination ge = new GaussianElimination();
                        System.out.println("\nEnter number of variables");
                        int N = scan.nextInt();
                        double[] B = new double[N];
                        double[][] A = new double[N][N];
                        System.out.println("\nEnter the coefficients of each variable and constant for each Equations in Matrix form");
                        for (int i = 0; i < N; i++)
                        {
                            for (int j = 0; j < N; j++)
                            {
                                 A[i][j] = scan.nextDouble();
                            }
                                 B[i] = scan.nextDouble();
                        }
                        ge.solve(A,B);
            }
            
            else if(cho==2)
            {
                        //Gauss Jordan Elimination  
                        System.out.println("Enter the Number of Variables in the Equations: ");
                        int n = scan.nextInt();
                        System.out.println("Enter the coefficients of each variable and constant for each Equations in Matrix form");
                        //matrix object declaretion
                        double [][]mat = new double[n][n];
                        double []constants = new double[n];
                        //input
                        for(int i=0; i<n; i++)
                            {
                                for(int j=0; j<n; j++)
                                {
                                    mat[i][j] = scan.nextDouble();
                                }
                                constants[i] = scan.nextDouble();
                            }
                        test(mat, constants);          
            }
            
            else if(cho==3)
            {
                        //Gauss Seidal Elimination
                        System.out.println("Gauss Seidal Method Implementation:");
                        System.out.println("Enter the Number of Variables in the Equations: ");

                        int n = scan.nextInt();
                        double a[][] = new double [n][n];
                        double b[] = new double [n];
                        double x[] = new double [n];

                        //input
                        System.out.println("Enter the coefficients of each variable and constant for each Equations in Matrix form");
                        for(int i=0; i<n; i++) {
                            for(int j=0; j<n; j++) {
                                a[i][j] = scan.nextDouble();
                                }
                            b[i] = scan.nextDouble();
                        }
                        System.out.println("Enter the value of 'es': ");
                        double es = scan.nextDouble();
                        System.out.println("Enter maximum number of iterations: ");
                        int imax = scan.nextInt();
                        GaussSeidel gs = new GaussSeidel(n, a, b, x, es, imax);
            }     
            
            
                else
                    System.out.println("Wrong Choice!!");
        }
        
        else if(choice == 3 ) {
            System.out.println("Liner Regression");
            
            System.out.print("\nEnter The Number of Pairs: ");
            int n = scan.nextInt();
            double [] x = new double[n];
            double [] y = new double[n];
            
            System.out.println("Enter The Values Of Pair's: ");
            for(int i=0 ; i<n ; i++) {
                x[i] = scan.nextDouble();
                y[i] = scan.nextDouble();
            }
            
            LinearRegression lr;
            lr = new LinearRegression(x,y,n);
        }
        
        else if(choice == 4) {
            System.out.println("#Interpolation:\n1. Newtons Divide-Difference Interpolating Polinomial");
            System.out.println("2. Lagrange Polinomial");
            int sc4 = scan.nextInt();
            switch (sc4) {
                case 1:
                    System.out.println("#Newtons Divide-Difference Interpolating Polinomial");
                    
                    System.out.println("Enter the number of order: ");
            		int n = scan.nextInt();
            		NewtonsInterpolating np = new NewtonsInterpolating(n);
                    
                    
                    
                    break;
                case 2:
                    System.out.println("#Lagrange Polinomial");
                    
                    System.out.println("Enter the number of order: ");
            		int nn = scan.nextInt();
            		LagrangePolynomial lP = new LagrangePolynomial(nn);
                    
                    break;
                default:
                    System.out.println("Wrong Selection!!");
                    break;
            }
                
        }
         
        else
                    System.out.println("Wrong Choice!!");
            }
}
