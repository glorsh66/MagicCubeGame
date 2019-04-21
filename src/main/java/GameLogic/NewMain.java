package GameLogic;

public class NewMain {

    public static void main(String[] args) {

        double j = 0.1;
        for (int i=0; i <20; i++)
        {

            System.out.println("J: " + j+ " log: "  +  Math.log(j));
            j+=0.05;

        }

    }
}
