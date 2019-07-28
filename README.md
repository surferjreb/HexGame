# HexGame
A program to solve hexagon puzzle game.  The game board is in the shape of a hexagon with 7 positions to place a piece.  There are 7 game pieces, each numbered 1-6.  Each piece has a specific order the numbers are arranged.  The solution is found by matching the outer pieces to the center, then checking to see if the sides that the outer pieces match.  All have to match for a correct solution. 
Piece numbers.
  Piece 1 - [1, 2, 3, 4, 5, 6]
  Piece 2 - [1, 2, 5, 6, 3, 4]
  Piece 3 - [1, 3, 5, 2, 4, 6]
  Piece 4 - [1, 3, 5, 4, 2, 6]
  Piece 5 - [1, 4, 2, 3, 5, 6]
  Piece 6 - [1, 5, 3, 2, 6, 4]
  Piece 7 - [1, 6, 5, 4, 3 ,2]
  
The Program takes in the initial pieces and starts with one, rotates the piece one position, then matches the outer pieces to the center.  Then checks the solution, verifying the positions match.  If they do not match it rotates the center and repeats. If no solution is found then it rotates all the pieces around the board.  I did have difficulty finding a solution this way, because the pieces still stayed in somewhat of order.  I introduced a method of swaping a random piece with the 5th piece.  This cut runtime significantly.  Once a solution is found the Program prints the solution to screen and to a text file solution. 
