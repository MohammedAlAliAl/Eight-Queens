import java.util.HashSet;
import java.util.Set;

public class Chessboard {
    //private Piece[][] chessboard;
    Node [][] board;

    public Chessboard() {

        board = new Node[8][8];
        initializeNodes();

    }
    private void initializeNodes() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = new Node(row, col);
            }
        }
    }
    public Node getNode(int row, int col) {
        if (isInsideBoard(row, col)) {
            return board[row][col];
        }
        return null;
    }


    /* add -1
    public void addValue(){
        for (int i = 0; i < chessboard.length; i++)
            for (int j = 0; j < chessboard[i].length; j++) {
                chessboard[i][j] = -1;
            }


    }*/
    public void addValue() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col].piece = null;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j].piece;
                if (piece == null) {
                    System.out.print(" -1 "); // empty square
                } else {
                    System.out.print(" " +piece.type.toString().charAt(0) + " "); // print first letter of type
                }
            }
            System.out.println();
        }
    }


    public Node getPieceAt(int row, int col) {
        if (isInsideBoard(row, col)) {
            return board[row][col];
        }
        return null;
    }
    public void setPieceAt(int row, int col, Piece piece) {
        if (isInsideBoard(row, col)) board[row][col].piece = piece;
    }


    private boolean isInsideBoard(int row, int col) {
        return row >= 0 & row < 8 && col >= 0 & col < 8;
    }

    public boolean hasQueenConflict(){
        int N = board.length;
        int[] queens = new int[N]; // queens[row] = column

        // Fill queen positions
        for (int row = 0; row < N; row++) {
            boolean found = false;
            for (int col = 0; col < N; col++) {
                Piece p = board[row][col].piece;
                if (p != null && p.type == PieceType.QUEEN) {
                    queens[row] = col;
                    found = true;
                    break; // assume only one queen per row
                }
            }
            if (!found) return false; // invalid state: row must have one queen
        }

        Set<Integer> columns = new HashSet<>();
        Set<Integer> ascDiags = new HashSet<>();
        Set<Integer> descDiags = new HashSet<>();

        for (int row = 0; row < N; row++) {
            int col = queens[row];
            if (!columns.add(col) ||
                    !ascDiags.add(row + col) ||
                    !descDiags.add(row - col)) {
                return true; // conflict detected
            }
        }
        return false;


    }

    public static void main (String[]args){
        Chessboard board = new Chessboard();
        board.addValue();

        board.setPieceAt(3,3,new Piece(PieceType.QUEEN ));
        board.setPieceAt(4,0, new Piece(PieceType.QUEEN ));
        board.setPieceAt(3,0, new Piece(PieceType.QUEEN ));

        board.printBoard();
        if (board.hasQueenConflict()) {
            System.out.println("Conflict detected");
        }
        else {
            System.out.println("No conflict detected");
        }
    }

}




