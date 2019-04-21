package GameLogic;

import java.util.ArrayList;

import java.util.Random;

public class Main {

    public static double[] getArray(int n)
    {

        double randoms[] = new  double[n];
        double randoms_pr[] = new  double[n];
        double logs[] = new  double[n];
        double logs_minus_one[] = new  double[n];


        double a[] = new double[n];

        double s = 0.0d;
        Random random = new Random();
        for (int i = 0; i < n; i++)
        {
            double r = random.nextDouble();
            randoms[i] = r;
            double pr = 1.0d - r;
            randoms_pr[i] = pr;

            a [i] = pr;
            double log = Math.log(a[i]);
            logs[i] = log;


            a [i] = -1 * log;
            logs_minus_one[i] = -1 * log;;

           //  = -1 * Math.log(a[i]);
            s += a[i];
        }

        for (int i = 0; i < n; i++)
        {
            double result = a [i] /= s;
            a [i] = result;
        }
        return a;
    }





    public static void main(String[] args) {
        double[] da = getArray(4);
        double sum =0;
        for (int i=0; i<da.length; i++)
        {
            System.out.print(da[i] + " ");
            sum+=da[i];
        }
        System.out.println(sum );




    }




}
