


import java.util.ArrayList;


public class Hexagon<hexPiece> {
    private static Hexagon hexagon = null;
    private final int MAX_INDEX = 7;

    private ArrayList<int[]> hexPieces;

    private Hexagon() {
        System.out.println("Hexagon piece created");
        hexPieces = new ArrayList<>(MAX_INDEX);
        setHexPieces();
    }
//===========================================
    public static Hexagon getInstance(){
        if(hexagon == null){
            hexagon = new Hexagon();

            return hexagon;
        }

        return null;
    }
//===========================================
    private void setHexPieces(){
        //builds an array list of the values on the game pieces.
        int[] a = {1,2,3,4,5,6};
        int[] b = {1,2,5,6,3,4};
        int[] c = {1,3,5,2,4,6};
        int[] d = {1,3,5,4,2,6};
        int[] e = {1,4,2,3,5,6};
        int[] f = {1,5,3,2,6,4};
        int[] g = {1,6,5,4,3,2};

        hexPieces.add(a);
        hexPieces.add(b);
        hexPieces.add(c);
        hexPieces.add(d);
        hexPieces.add(e);
        hexPieces.add(f);
        hexPieces.add(g);

    }//end setPieces
//===========================================
    public int[] getHexPiece(int index) {
        return hexPieces.get(index);
    }
//===========================================
    public void setHexPiece(int[] hexPNumbers, int index) {
        hexPieces.set(index, hexPNumbers);
    }
//===========================================
    public int[] rotatePiece(int[] piece){
        int temp;

        for(int i = 0; i < piece.length - 1; i++){
            temp = piece[i];
            piece[i] = piece[i + 1];
            piece [i +1] = temp;
        }

        return piece;
    }
}//End of Class
