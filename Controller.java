

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;

public class Controller {
    private final int MAX_INDEX_BOARD = 7;
    private final int MAX_INDEX_PIECE = 6;
    HexBoard myBoard;

    public Controller() {
        System.out.println("Controller created");
        myBoard = new HexBoard();
    }

    public void startGame() {
        //starts the game, initialize the board, and begin to find solution
        myBoard.setGameBoard();
       //myBoard.displayBoard();
        runGame();
    }//end startGame

    private void runGame() {
        int count = 0;
        ArrayList pieces = new ArrayList(7);
        boolean solutionFound = false;
        solutionFound = generateSolutions();

        if(solutionFound){
            System.out.println("Solution");
            myBoard.displayBoard();
            System.out.println("*** Solution ***");
            myBoard.writeToFile();
        }
        else{
            System.out.println("I failed again....");
        }
    }//end runGame






    private boolean checkSolutions(ArrayList positions){
//        if(checkSolutionOne(positions)){
//
//            if(checkSolutionTwo(positions)){
//               // System.out.println("match found2");
//                if(checkSolutionThree(positions)){
//                    System.out.println("match found3");
//                    return true;
//                }
//            }
//        }

        return false;
    }

    private boolean checkSolutionOne(ArrayList positions) {
        int[] piece1 = (int[]) positions.get(1);
        int[] piece2 = (int[]) positions.get(2);
        int[] piece3 = (int[]) positions.get(6);

        if (piece1[2] == piece2[5]) {

            if (piece1[4] == piece3[1]) {
                return true;
            }
        }

        return false;

        // if(checkOneTwoSix(pieces)){

        //     if(checkfourThreeFive(pieces)){

        //        if(checkThreeFour(pieces) && checkSixSeven(pieces)){
    }

    private boolean checkSolutionTwo() {

            int[] piece4 = myBoard.getPosition(4);
            int[] piece3 = myBoard.getPosition(3);
            int[] piece5 = myBoard.getPosition(5);

            if (piece4[1] == piece3[4]) {

                if (piece4[5] == piece5[2]) {
                    return true;
                }

            }

        return false;

        // if(checkOneTwoSix(pieces)){

        //     if(checkfourThreeFive(pieces)){

        //        if(checkThreeFour(pieces) && checkSixSeven(pieces)){
    }

    private boolean checkSolutionThree(ArrayList positions) {
        int[] piece1 = (int[]) positions.get(2);
        int[] piece2 =  (int[]) positions.get(3);
        int[] piece3 =  (int[]) positions.get(5);
        int[] piece4 =  (int[]) positions.get(6);

        if (piece1[3] == piece2[0]) {
            if (piece3[0] == piece4[3]) {
                return true;
            }
        }

        return false;

        // if(checkOneTwoSix(pieces)){

        //     if(checkfourThreeFive(pieces)){

        //        if(checkThreeFour(pieces) && checkSixSeven(pieces)){
    }

    private boolean generateSolutions(){
        boolean isSolution = false;
        int count=0;
        for(int a = 0; a < MAX_INDEX_BOARD; a++){
            for(int b = 0; b < MAX_INDEX_BOARD; b++){
                for(int c = 0; c < MAX_INDEX_BOARD; c++){
                    for(int d = 0; d < MAX_INDEX_BOARD; d++){
                        for(int e = 0; e < MAX_INDEX_BOARD; e++){
                            for(int f = 0; f < MAX_INDEX_BOARD; f++) {
                                for (int g = 0; g < MAX_INDEX_BOARD; g++) {
                                    for(int x =0; x < MAX_INDEX_PIECE; x++) {
                                        for(int y = 0; y < MAX_INDEX_PIECE; y++) {
                                            myBoard.matchCenterPiece();
                                            isSolution = checkSolutionOne(myBoard.getPositionList());
                                            if (isSolution) {
                                              //  System.out.println("I reached here");
                                                isSolution = checkSolutionTwo();
                                                if (isSolution) {
                                                 //   System.out.println("Did i make it here");
                                                    isSolution = checkSolutionThree(myBoard.getPositionList());
                                                    if (isSolution) {
                                                        System.out.println("Maybe...");
                                                        return true;
                                                    }
                                                }
                                            }
                                            count++;
                                            //     myBoard.displayBoard();
                                            myBoard.rotateCenterPiece();
                                        }
                                        myBoard.rotateOuterPieces();
                                    }
                                   myBoard.swapPieces();
                                    myBoard.rotateBoardPieces();
                                }

                            }


                        }

                    }
                }
            }
        }
        System.out.println(count);
        return false;

    }//end generate

}//End controller
