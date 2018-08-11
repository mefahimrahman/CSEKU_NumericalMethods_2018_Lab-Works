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
public class BisectionMethod {
   int count = 1;
    double temp;
    double Ea;

       public void BMethod(double Xl, double Xu, double Es){
           while(true) {

               double Xr = (Xl + Xu) / 2;
              // double Et = ETRelativeError(tvalue, Xr);
               if(count == 1)
                   System.out.println(count+"     "+Xl+"     "+Xu+"     "+Xr+"    'no Ea'      ");
               else {
                   Ea = Math.abs(EaApproximateError(Xr, temp));
                   System.out.println(count+"     "+Xl+"     "+Xu+"     "+Xr+"     "+Ea+"      ");
                   if(Ea < Es)
                       break;
               }
               double mul = FValue(Xl) * FValue(Xr);
               if (mul < 0) {
                   Xu = Xr;
               } else {
                   Xl = Xr;
               }
               temp = Xr;

               count++;
           }
       }
       /*public double FValue(double c){
           double r = ((667.38/c) * (1-Math.exp(-.146843*c))) - 40;
           return r;
       }*/
       
       public double FValue(double c){
           double r = (-26+82.3*c-88*c*c+45.4*c*c*c-9*c*c*c*c+0.65*c*c*c*c*c);
           return r;
       }

       public double ETRelativeError(double t, double a){
           return ((t - a)/t)*100;
       }

       public double EaApproximateError(double now, double old){
           return ((now-old)/now)*100;
       }
}