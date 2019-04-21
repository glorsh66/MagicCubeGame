import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



public class RandomLogic {


    public static  int get_random (Random r, double[] elements) {
        double diceRoll = r.nextDouble();
        double cumulative = 0.0;


        for (int i = 0; i < elements.length; i++) {
            cumulative += elements[i];
            if (diceRoll < cumulative) {
                return i;
            }

        }
        return 0;
    }



    public static  int get_random_bound (Random r, double[] elements, double bound) {
        double diceRoll =  r.nextDouble();
        double cumulative = 0.0;


        for (int i = 0; i < elements.length; i++) {
            cumulative += elements[i];
            if (diceRoll < cumulative) {
                return i;
            }

        }
        return 0;
    }




    public static  int get_random_int (Random r, int[] elements,int cum_summ) {
        int diceRoll = r.nextInt(cum_summ);
        int cumulative = 0;


        for (int i = 0; i < elements.length; i++) {
            cumulative += elements[i];
            if (diceRoll < cumulative) {
                return i;
            }

        }
        return 0;
    }




    public static void main(String[] args) {

        Random r = new Random();
        double[] elements = {1,1,100000};
        int[] ar = {0,0,0};


        double cum_sum = 0;
        for (int i = 0; i < elements.length; i++) cum_sum+= elements[i];


        double[] cum_elements = {0,0,0};
        for (int i = 0; i < elements.length; i++) cum_elements[i] = elements[i]/cum_sum;


        double cum_sum_test = 0;
        for (int i = 0; i < elements.length; i++) cum_sum_test+= cum_elements[i];


        for (int i = 0; i < 10000000; i++) {
            ar[get_random_bound(r, cum_elements,cum_sum)]++;
        }


        double sum=0;
        for (int i = 0; i < elements.length; i++) sum+= ar[i];


        System.out.println("cum_sum: " + cum_sum);
        System.out.println("cum_sumtest: " + cum_sum_test );

        for (int i = 0; i < elements.length; i++)
        {

            System.out.print("Индекс: " + i + " Вероятность: " + elements[i] + " cum ver: " + cum_elements[i] +  " Колличество: " + ar[i] + " Процент: " + ar[i]/sum*100 );
            System.out.println();


        }

    }










    public static void main_3(String[] args) {

        Random r = new Random();
        int[] elements = {10,80,10};
        //ArrayList<Integer> ar = new ArrayList<>();
        int[] ar = {0,0,0};





        int cum_sum = 0;
        for (int i = 0; i < elements.length; i++) cum_sum+= elements[i];


        for (int i = 0; i < 100000; i++) {
            ar[get_random_int(r, elements,cum_sum)]++;
        }


        double sum=0;
        for (int i = 0; i < elements.length; i++) sum+= ar[i];

        for (int i = 0; i < elements.length; i++)
        {

            System.out.print("Индекс: " + i + " Вероятность: " + elements[i] + " Колличество: " + ar[i] + " Процент: " + ar[i]/sum*100 );
            System.out.println();
        }
    }




    public static void main_2(String[] args) {

        Random r = new Random();
        double[] elements = {0.1d,0.8d,0.1d};
        //ArrayList<Integer> ar = new ArrayList<>();
        int[] ar = {0,0,0};



        for (int i = 0; i < 10000000; i++) {
        ar[get_random(r, elements)]++;
        }


        double sum=0;
        for (int i = 0; i < elements.length; i++) sum+= ar[i];

        for (int i = 0; i < elements.length; i++)
        {

            System.out.print("Индекс: " + i + " Вероятность: " + elements[i] + " Колличество: " + ar[i] + " Процент: " + ar[i]/sum*100 );
            System.out.println();


        }

        }
    }

