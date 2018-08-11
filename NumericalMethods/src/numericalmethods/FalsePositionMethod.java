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
public class FalsePositionMethod {
     int count;
    double temp;
    public void FMethod(double Xi, double Xu, double tvalue, double Es){
        count = 1;
        while(true){
            double Xr = getXr(Xi, Xu);
            double Et = Math.abs(ETRelativeError(tvalue, Xr));
            if(count==1) {
                System.out.println(count+"      "+Xi + "         " + Xu + "        " + Xr + "              'no Ea'             " + Et);
            }
            else{
                double Ea = Math.abs(EaApproximateError(Xr, temp));
                System.out.println(count+"      "+Xi + "         " + Xu + "     " + Xr + "        "+Ea+"         " + Et);
                if(Ea < Es)
                    break;
            }
            double mul = FValue(Xi) * FValue(Xr);
            if (mul < 0) {
                Xu = Xr;
            } else {
                Xi = Xr;
            }
            temp = Xr;
            count++;
        }
    }

    public double FValue(double c){
        return ((667.38/c) * (1-Math.exp(-.146843*c))) - 40;
    }

    public double getXr(double Xi, double Xu){
        return Xu - (FValue(Xu)*(Xi-Xu) / (FValue(Xi)-FValue(Xu)));
    }

    public double ETRelativeError(double t, double a){
        return ((t - a)/t)*100;
    }

    public double EaApproximateError(double now, double old){
        return ((now-old)/now)*100;
    }
}
