/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral;

/**
 *
 * @author heten
 */
import java.util.Random;

public class Integral {
    //function
    public static double f(double x) {
        //return (4/1+x*x);
       return(3*x+1);
       // return(5*x*x+2*x-4);
    // return (1/x*Math.log(x));
    }

    public static double Integrate(double a, double b, int n) {
       
        double area = 0, h = 0, i = 0;
        if (a > b)
            return Integrate(b, a, n);
        h = (b - a) / n;
        for (i = a; i <= b; i = i + h) {
            area = area + h * f(i);
        }
        return area;
    }
    
    
             public static double trapzoid (double a, double b, double n) { 
       //trapzoid
       double h = (b - a) / n;
        double sum = 0.5 * (f(a) + f(b));
        for (int i = 1; i < n; i++) {
            double x = a + h * i;
            sum = sum + f(x);
        }

        return sum * h;
    }

    public static double midpoint(double a, double b, double n) {

 // midpoint
            return a/2 + b/2 + (a%2 + b%2)/2;
     /*    if (a > b)
            return Integrate(b, a, n);
        double h =(b-a)/n;
        double returnValue =0;
        for(int i=0; i<n; i++)
            returnValue = returnValue +((a +h/2)*(i*h));
             return returnValue *h;*/
                    }

    
        public static double SimpsonsRule(double a, double b, double  n) {
    //SimpsonsRule
    
    double h = (b - a) / (n - 1);     // step size
 
      double sum = 1.0 / 3.0 * (f(a) + f(b));

      for (int i = 1; i < n - 1; i += 2) {
         double x = a + h * i;
         sum += 4.0 / 3.0 * f(x);
      }
      for (int i = 2; i < n - 1; i += 2) {
         double x = a + h * i;
         sum += 2.0 / 3.0 * f(x);
      }

      return sum * h;
   }


    public static void main(String[] args) {
        Random rand = new Random();
        double num1 = rand.nextDouble();
        double num2 = rand.nextDouble();

        double a = Math.min(num1, num2);
        double b = Math.max(num1, num2);
        System.out.println("The answer for questions 1 is: " + Integral.Integrate(1, 0, 10000));
        System.out.println(" The answer for questions 2 is: " + Integral.trapzoid(5, 2, 10000));
        System.out.println("The answer for questions 3 is: " + Integral.midpoint(4, 1, 10000));
        System.out.println("The answer for questions 4 is: " + Integral.SimpsonsRule(Math.E+1, Math.E, 10000));

        System.out.println("The random number 10000 iteration  is: " + String.format("%.3f", Integral.Integrate(num1, num2, 10000)));
   
        System.out.println("The trapzoid 10000 iteration is: " + Integral.trapzoid(1,0,0.5));

        System.out.println("The  midpoint 10000 iteration is: " + Integral.midpoint(0.5, 0.1, 10000));

        System.out.println("The SimpsonsRule  10000 iteration is: " + String.format("%.3f", Integral.SimpsonsRule(0.5, 0.1, 10000)));

    }
}
