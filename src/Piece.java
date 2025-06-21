import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chess piece.
 * Currently supports move generation only for the Queen.
 */

public class Piece {
    PieceType type;
    int row;
    int col;
   boolean hasMoved;

    /**
     * Constructs a Piece of a given type.
     * Position is not set here and should be handled elsewhere (e.g., via Node).
     *
     * @param type the type of the chess piece
    * */
   public Piece(PieceType type){
       this.type = type;
       hasMoved = false;

   }

    /**
     * Returns a list of possible move positions for this piece,
     * depending on its type and ignoring actual board obstacles.
     *
     * Currently implemented only for QUEEN.
     *
     * @param chessboard the board context to calculate moves
     * @return a list of valid target positions
     */
   public List<Position> getPossibleMoves(Chessboard chessboard) {
       List<Position> moves = new ArrayList<>();
       if (type == PieceType.QUEEN) {
           // Queen moves in 8 directions: vertical, horizontal, and both diagonals
           int[][] directions = {
                   {-1, 0},
                   {1, 0},
                   {0, -1},
                   {-1, 1},
                   {-1, -1},
                   {1, 1},
                   {1, -1},
                   {0, 1}};
           for (int[] direction : directions) {
               int newRow = row + direction[0];
               int newCol = col + direction[1];
               while (IsInsideBoard(newRow, newCol)){
                   moves.add(new Position(newRow, newCol));
                   newRow = newRow + direction[0];
                   newCol = newCol + direction[1];
               }
           }
       }
       return moves;

   }

    /**
     * Checks whether a given position is within the bounds of an 8x8 board.
     *
     * @param row the row index
     * @param col the column index
     * @return true if within board bounds, false otherwise
     */
   private boolean IsInsideBoard(int row, int col) {
       return row >= 0 & row <8 && col >= 0 & col <8;
   }


}
