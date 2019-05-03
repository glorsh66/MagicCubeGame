package GameLogic.RandomGenerator;

import GameLogic.RandomGenerator.Formulas.ChanceFormula;
import GameLogic.RandomGenerator.Formulas.IncrementFormula;

import java.util.Random;



public class RandomBoardGenerator {


    private int lowBound;
    private int highBound;
    private Random r;
    private double[] chances;
    private int[] numbers;
    private int arraySize;


public RandomBoardGenerator(int lowBound, int highBound)
{
    this.r = new Random();
    this.reorange(lowBound,highBound);
}




public static void helperPrint(double[] array ) {
    for (int i = 0; i < array.length; i++)
        System.out.println("Index: " + i + " Value: " + array[i]);
}

public static  void helperPrintInt(int[] array ) {
    for (int i = 0; i < array.length; i++)
        System.out.println("Index: " + i + " Value: " + array[i]);
}

public static <T> void helperPrintTemplate(T[] array ) {
        for (int i = 0; i < array.length; i++)
            System.out.println("Index: " + i + " Value: " + array[i]);
    }




public void reorange(int lowBound, int highBound)
{
    ChanceFormula f = new IncrementFormula();

    this.numbers = generateNumbers(lowBound,highBound);
    this.chances = normalizeArray(generateChancesLambda(lowBound,highBound,f));
    this.lowBound = lowBound;
    this.highBound = highBound;
    this.arraySize = chances.length;

}


private int[] generateNumbers(int lowBound, int highBound)
{
    //Define if our new array is supposed to be with even number of elements or not
    int arraySize = highBound - lowBound +1;

    //Fill the int array with ints from min to max bound
    int counter = lowBound;
    int[] numbers = new int[arraySize];
    for (int i =0; i<arraySize; i++)
        numbers[i] = counter++;
    return numbers;
}

@Deprecated
private double[] generateChances(int lowBound, int highBound)
{
     //Define if our new array is supposed to be with even number of elements or not
     int arraySize = highBound - lowBound;
     boolean isEven = ((arraySize+1) %2 == 0) ? true: false;
     int qualifier = 10;

    //Create double array
    double ar[] = new double[arraySize+1];
    System.out.println("Is even: " + isEven + " All elements: " + ar.length);

     if (isEven== true)
         for (int i=0; i<arraySize/2+1; i++){
         ar[arraySize-i] = (i/2+1)*qualifier;
         ar[i] = (i/2+1)*qualifier;
         }
     else
     {
         for (int i=0; i<arraySize/2; i++)
         {
             ar[arraySize-i] =((i/2+1)*qualifier);
             ar[i] =((i/2+1)*qualifier);
         }
         ar[arraySize/2] = (arraySize/2+1)*qualifier;
     }

     return ar;
}


    private double[] generateChancesLambda(int lowBound, int highBound, ChanceFormula f)
    {
        //Define if our new array is supposed to be with even number of elements or not
        int arraySize = highBound - lowBound;
        boolean isEven = ((arraySize+1) %2 == 0) ? true: false;

        //Create double array
        double ar[] = new double[arraySize+1];
        System.out.println("Is even: " + isEven + " All elements: " + ar.length);

        if (isEven== true)
            for (int i=0; i<arraySize/2+1; i++){
                ar[arraySize-i] = f.formula(i);
                ar[i] = f.formula(i);
            }
        else
        {
            for (int i=0; i<arraySize/2; i++)
            {
                ar[arraySize-i] =f.formula(i);
                ar[i] =f.formula(i);
            }
            ar[arraySize/2] = f.formula(arraySize/2);
        }

        return ar;
    }




private static double[] normalizeArray(double[] ar)
{
    double sum = 0;
    for (int i=0; i < ar.length; i++) sum+=ar[i];

    for (int i=0; i < ar.length; i++) ar[i] = ar[i]/sum;

    //Must check Exeption in the future
    double controlSum = 0;
    for (int i=0; i < ar.length; i++) controlSum+=ar[i];

    return ar;
}

private int getRandomIndex() {
        double diceRoll =  this.r.nextDouble();
        double cumulative = 0.0;

        for (int i = 0; i < this.chances.length; i++) {
            cumulative += this.chances[i];
            if (diceRoll < cumulative) {
                return i;
            }
        }
        return 0;
}


public int gerRandom()
{
    return this.numbers[getRandomIndex()];
}



@Deprecated
public static  int get_random_bound (Random r, double[] elements) {
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

    public void testFunct2()
    {
        Random r = this.r;
        double[] elements = this.chances;
        int[] ar = new int[this.chances.length];


        double cum_sum = 0;
        for (int i = 0; i < elements.length; i++) cum_sum+= elements[i];


        double[] cum_elements = new double[this.chances.length];
        for (int i = 0; i < elements.length; i++) cum_elements[i] = elements[i]/cum_sum;


        double cum_sum_test = 0;
        for (int i = 0; i < elements.length; i++) cum_sum_test+= cum_elements[i];


        for (int i = 0; i < 1000000; i++) {
            ar[getRandomIndex()]++;
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


@Deprecated
public static void testFunct()
{
    Random r = new Random();
    double[] elements = {1,1,100000};
    int[] ar = {0,0,0};


    double cum_sum = 0;
    for (int i = 0; i < elements.length; i++) cum_sum+= elements[i];


    double[] cum_elements = {0,0,0};
    for (int i = 0; i < elements.length; i++) cum_elements[i] = elements[i]/cum_sum;


    double cum_sum_test = 0;
    for (int i = 0; i < elements.length; i++) cum_sum_test+= cum_elements[i];


    for (int i = 0; i < 1000000; i++) {
        ar[get_random_bound(r, cum_elements)]++;
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


    public static void main(String[] args)
    {
      //  testFunct();
    RandomBoardGenerator rb = new RandomBoardGenerator(1,5);
    helperPrint(rb.chances);
    helperPrintInt(rb.numbers);


    rb.testFunct2();


    }




}
