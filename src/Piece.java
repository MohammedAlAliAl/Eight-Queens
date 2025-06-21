import java.util.ArrayList;
import java.util.List;

public class Piece {
    PieceType type;
    int row;
    int col;
   boolean hasMoved;

   public Piece(PieceType type){
       this.type = type;
       hasMoved = false;

   }
   public List<Position> getPossibleMoves(Chessboard chessboard) {
       List<Position> moves = new ArrayList<>();
       if (type == PieceType.QUEEN) {
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
   private boolean IsInsideBoard(int row, int col) {
       return row >= 0 & row <8 && col >= 0 & col <8;
   }

    public void setPosition(int row, int col) {
        this.row= row;
        this.col = col;

    }


}
