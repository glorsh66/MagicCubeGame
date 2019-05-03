package GameLogic;

import GameLogic.RandomGenerator.RandomBoardGenerator;

public class GameModel {

    public int maxNumber =0;
    public int score = 0;
    public int moves = 0;

    public GameBoard currentBoard;
    public GameBoard lastState;
    public RandomBoardGenerator rbg;


    int to = 6;
    int from = 1;


    public GameModel()
    {
        this.rbg = new RandomBoardGenerator(1,6);

    }

    private void initBoardFirstTurn(int rows, int columns)
    {

        this.lastState = null;
        this.currentBoard = new GameBoard(rows,columns);
    }


    public void helperPrintStats()
    {
        System.out.println();
        System.out.println("Turn: " + moves + " Score " + score + " Max number: " + maxNumber  + " from: " + from + " to: " + to);
        System.out.println();
    }


    public static void main(String[] args) {

       GameModel gm = new GameModel();

       gm.initBoardFirstTurn(5,5);
       gm.currentBoard.fillArrayPredetermined();


       gm.helperPrintStats();
       gm.currentBoard.helperPrintBoard();
       gm.currentBoard.tochHasNeighbours(3,3);



       int testElement = 13;
       gm.currentBoard.hasLeft(testElement);
       gm.currentBoard.hasUp(testElement);
       gm.currentBoard.hasRight(testElement);
       gm.currentBoard.hasDown(testElement);




//       gm.currentBoard.toch(3,1);
//       gm.currentBoard.toch(2,5);
//       gm.currentBoard.toch(5,5);


    }




}
