package GameLogic;

import GameLogic.RandomGenerator.RandomBoardGenerator;

public class GameBoard {
    public int rows;
    public int columns;
    public int gameBoard[];
    public int gameBoardInProgress[];


    public int size;


    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.size = rows * columns;

        this.gameBoard = new int[size]; // Optimization. a single dimension array
    }

    public void fillArrayPredetermined()
    {
        this.gameBoard = new int[]
               {6, 2, 3, 1, 1,
                5, 2, 3, 3, 1,
                4, 3, 3, 3, 1,
                6, 3, 2, 1, 1,
                1, 3, 1, 1, 1};

    }


    public void fillArrayFirstTurn(RandomBoardGenerator rbg)
    {
        for (int i =0; i< this.gameBoard.length; i++)
            gameBoard[i] = rbg.gerRandom();
    }





    public int deleteBlock(int element)
    {
        game
    }


    public boolean hasLeft(int element)
    {
        int currentValue = gameBoard[element-1];

        float division = (float)element / (float)columns;

        int row = (int) Math.ceil(division);
        int column =  element - ((row-1) * columns);

        boolean hasLeft =false;

        //check if it has an equal element on the left side
        if (column > 1)
            if ( gameBoard[element -1 - 1] == currentValue) hasLeft= true;

        //Debug method;
        System.out.println("Element number: " + element +" Value: " + gameBoard[element -1] + " HasLeft: " + hasLeft  + " Row: " + row + " Column: " + column + " index: " + (element-1) + " Div: " + division );
        return  hasLeft;

    }


    public boolean hasRight(int element)
    {
        int currentValue = gameBoard[element-1];

        float division = (float)element / (float)columns;

        int row = (int) Math.ceil(division);
        int column =  element - ((row-1) * columns);

        boolean hasRight =false;

        //check if it has an equal element on the right side
        if (column < columns)
            if ( gameBoard[element -1  + 1] == currentValue) hasRight= true;

        //Debug method;
        System.out.println("Element number: " + element +" Value: " + gameBoard[element -1] + " hasRight: " + hasRight + " Row: " + row + " Column: " + column + " index: " + (element-1) + " Div: " + division );
        return  hasRight;
    }



    public boolean hasUp(int element)
    {
        int currentValue = gameBoard[element-1];

        float division = (float)element / (float)columns;

        int row = (int) Math.ceil(division);
        int column =  element - ((row-1) * columns);

        boolean hasUp=false;

        //Check if it has an equal element up above
        if (row > 1)
            if ( gameBoard[element-1-columns] == currentValue ) hasUp = true;

        //Debug method;
        System.out.println("Element number: " + element +" Value: " + gameBoard[element -1] + " hasUp: " + hasUp + " Row: " + row + " Column: " + column + " index: " + (element-1) + " Div: " + division );
        return  hasUp;
    }


    public boolean hasDown(int element)
    {
        int currentValue = gameBoard[element-1];

        float division = (float)element / (float)columns;

        int row = (int) Math.ceil(division);
        int column =  element - ((row-1) * columns);

        boolean hasDown=false;

        //check if it has an equal element down
        if (row < this.rows)
            if ( gameBoard[element-1 + columns] == currentValue) hasDown= true;

        //Debug method;
        System.out.println("Element number: " + element +" Value: " + gameBoard[element -1] + " hasDown: " + hasDown + " Row: " + row + " Column: " + column + " index: " + (element-1) + " Div: " + division );
        return  hasDown;
    }


    public boolean tochHasNeighbours(int row, int column)
    {
    boolean hasLeft = false, hasRight = false, hasUp = false, hasDown = false;
    int currentValue;

    int elNumber = ( (row-1) * columns + column) -1;


    //assign current value
    currentValue = gameBoard[elNumber];

    //Check if it has an equal element up above
    if (row > 1)
        if ( gameBoard[elNumber-columns] == currentValue ) hasUp = true;

    //check if it has an equal element down
    if (row < this.rows)
        if ( gameBoard[elNumber+columns] == currentValue) hasDown= true;

    //check if it has an equal element on the left side
    if (column > 1)
        if ( gameBoard[elNumber - 1] == currentValue) hasLeft= true;

    //check if it has an equal element on the right side
    if (column < columns)
        if ( gameBoard[elNumber + 1] == currentValue) hasRight= true;


    //Debug method;
    System.out.println("Element number: " + elNumber +" Value: " + currentValue
    + " HasUp: " + hasUp + " HasRight: " + hasRight + " HasDown: " + hasDown + " HasLeft: " + hasLeft );

    //return statement
    if (hasUp || hasRight || hasDown || hasLeft) return  true;
    else return false;

    }



    public void helperPrintBoard()
    {


        String newline =  System.getProperty("line.separator");
        System.out.println();
        System.out.println("Game Board:" + "Size: " + size + " Rows: " + rows + " Columns: " + columns);
        System.out.println();

        for (int i =0; i< this.gameBoard.length; i++){


            int ostatok = (i+1) % columns;

            if (ostatok == 0)
            {
                if (i!=0)  System.out.format("%3d" + newline, gameBoard[i]);
                else System.out.format("%3d", gameBoard[i]);
            }
            else
            {
                System.out.format("%3d", gameBoard[i]);
            }
        }

        System.out.println();
        System.out.println("GameBoard end");



    }


}
