package numericalmethods;

public class GaussSeidel {

	public GaussSeidel (int n,double a[][],double b[], double x[],double es,int imax)
	{
            int sentinel;
            for(int i = 0; i < n; i++)
		{
                    double dummy = a[i][i];
                    for(int j = 0; j < n; j++) {
				a[i][j] = a[i][j] / dummy;
			}
                        //dividing both x terms coefficient and constant with xi's terms coefficient
			b[i] = b[i] / dummy;
		}
            for(int i = 0; i < n; i++) {
                    double sum = b[i];
                    for(int j = 0; j < n; j++) {
                            if(i != j)
                            {
                                    //assuming other terms 0 except the xi term
                                    sum = sum - a[i][j]*x[j];
                            }
                    }
                    x[i] = sum;
		}
		int iter = 1;
		//substituting the value of x that we get after setting each value of x term = 0
            do {
                    sentinel = 1;
                    for(int i = 0; i < n; i++)
                    {
                            double sum = b[i];
                            double old = x[i];
                            for(int j = 0; j < n; j++) 
                            {
                                if(i != j)
                                {
                                    //substituting the value of x terms  that we get previously except the ith term
                                    sum = sum - a[i][j] * x[j];
                                }
                            }
                            x[i] = sum;
                            if(sentinel == 1 && x[i] != 0)
                            {
                            double ea = Math.abs((x[i] - old) / x[i]) * 100;
                            if (ea > es) 
                            {
                                sentinel = 0;
                            }
                            }
                    }
			iter += 1;
		} while (sentinel == 1 || iter >= imax);
		//output print
		System.out.println("Solution for Gauss Seidel is :");
		 for(int i = 0; i < n; i++) {
			System.out.print("X" + (i+1) +" = ");
                        System.out.printf("%.4f ", x[i]);
                        System.out.println("");
		}
	}
}