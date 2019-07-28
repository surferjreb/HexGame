


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HexBoard {
    private final int MAX_INDEX_POSITION = 7;
    private final int MAX_INDEX_PIECE = 6;
    private final int CENTER_PIECE = 0;
    private Hexagon myHex;
    private ArrayList<int[]> position;
    private Random myRand;

    public HexBoard(){
        System.out.println("HexBoard is created");
        myHex = Hexagon.getInstance();
        position = new ArrayList<>(MAX_INDEX_POSITION);
        myRand = new Random();
    }

    public void setGameBoard(){

        for(int i = 0; i < MAX_INDEX_POSITION; i++){
            position.add(i, myHex.getHexPiece(i));
        }

    }

    public int[] getPosition(int index) {
        return position.get(index);
    }

    public void displayBoard(){
        for(int i = 0; i < MAX_INDEX_POSITION; i++){
            int[] positionNumbers =  getPosition(i);

            System.out.print(i +" " );

            for(int j = 0; j < MAX_INDEX_PIECE; j++) {
                System.out.print(positionNumbers[j]);
            }

            System.out.print("\t");
        }
        System.out.println();
    }//end display board
//=========================================================

//=========================================================
//    public int[] rotatePiece(int index){
//        int[] piece = myHex.getHexPiece(index);
//        int temp;
//        for(int i = 0; i < piece.length - 1; i++){
//            temp = piece[i];
//            piece[i] = piece[i+1];
//            piece[i+1] = temp;
//        }
//        myHex.setHexPiece(piece, index);
//        return myHex.getHexPiece(index);
//    }
//=========================================================
    public void matchCenterPiece(){


    int[] centerPiece = getPosition(CENTER_PIECE);

    matchCenterToNextPiece(centerPiece);


}
//=========================================================
    private void matchCenterToNextPiece(int[] centerPiece){
        int index = 1;
        int[] piece;


        for(int i = 0; i < MAX_INDEX_PIECE; i++){
            piece = position.get(index);

            if(i < 3) {
                while (centerPiece[i] != piece[i + 3]) {
                    piece = myHex.rotatePiece(piece);
                }
                position.set(index, piece);
                index++;
            }
            else{
                while (centerPiece[i] != piece[i - 3]) {
                    piece = myHex.rotatePiece(piece);
                }
                position.set(index, piece);
                index++;
            }


        }
        index = 1;

    }
//=========================================================
    public void rotateCenterPiece(){
        int[] centerPiece = position.get(CENTER_PIECE);
        int[] tempNumberList;

        tempNumberList = myHex.rotatePiece(centerPiece);
        position.set(CENTER_PIECE, tempNumberList);

    }
//=========================================================
    public void rotateBoardPieces(){
        for(int i = 0; i < position.size() - 1; i ++){
            int[] temp;

            temp = position.get(i);
            position.set(i, getPosition(i+1));
            position.set(i+1, temp);

        }

    }
//=========================================================
    public void rotateOuterPieces(){
        int[] temp;

        for(int i = 1; i < MAX_INDEX_POSITION-1; i++){
            temp = getPosition(i);
            position.set(i, getPosition(i+1));
            position.set(i+1, temp);
        }
    }
//===========================================================

//===========================================================
    public void swapPieces(){
        int[] temp;
        int index = myRand.nextInt(6);

        temp = getPosition(index);
        position.set(index, getPosition(0));
        position.set(0, temp);


    }
//===========================================================
    public ArrayList getPositionList(){
        return position;
    }
//=========================================================
    public void writeToFile(){
        String fileName = "solutions.txt";
        int[] temp;
        try(FileWriter fileWriter = new FileWriter(fileName, true)){

            fileWriter.write("\n");
            fileWriter.write("***Solution***");
            fileWriter.write("\n");
          for(int i = 0; i < MAX_INDEX_POSITION; i++) {
              temp = getPosition(i);

                  fileWriter.write(Arrays.toString(temp));

        //    fileWriter.write(" ");
          }
          fileWriter.close();
        }
        catch(IOException e){
            System.out.println("This did not work.");
        }
    }
//=========================================================

}//end of clasee
