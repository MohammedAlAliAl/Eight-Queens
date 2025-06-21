import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chessboard {
    //private Piece[][] chessboard;
    Node[][] board;
    Set<Integer> columns = new HashSet<>();
    Set<Integer> ascDiags = new HashSet<>();
    Set<Integer> descDiags = new HashSet<>();
    List<Node[][]> allSolutions = new ArrayList<>();


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
                System.out.print(piece == null ? " -1 " : " Q ");


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

   /* public boolean hasQueenConflict(){
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


    }*/


    public boolean solveNQueens(int row) {
        if (row == 8) return true;
        for (int col = 0; col < 8; col++) {
            if (isSafe(row, col)) {
                placeQueen(row, col);
                if (solveNQueens(row + 1)) return true;
                removeQueen(row, col); // backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col) {
        return !columns.contains(col) &&
                !ascDiags.contains(row + col) &&
                !descDiags.contains(row - col);

    }

    private void placeQueen(int row, int col) {
        board[row][col].piece = new Piece(PieceType.QUEEN);
        columns.add(col);
        ascDiags.add(row + col);
        descDiags.add(row - col);
    }

    private void removeQueen(int row, int col) {
        board[row][col].piece = null;
        columns.remove(col);
        ascDiags.remove(row + col);
        descDiags.remove(row - col);
    }

    public void solveAllQueens(int row) {
        if (row == 8) {
            saveSolution(); // found one valid setup
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (isSafe(row, col)) {
                placeQueen(row, col);
                solveAllQueens(row + 1); // move to next row
                removeQueen(row, col);   // backtrack
            }
        }
    }

    private void saveSolution() {
        Node[][] copy = new Node[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Node original = board[i][j];
                copy[i][j] = new Node(i, j);
                if (original.piece != null) {
                    copy[i][j].piece = new Piece(original.piece.type);
                }
            }
        }
        allSolutions.add(copy);
    }

        public void printAllSolutions() {
            int count = 1;
            for (Node[][] solution : allSolutions) {
                System.out.println("Solution " + count++);
                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        System.out.print(solution[r][c].piece == null ? " -1 " : " Q ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }



    public static void main(String[] args) {
        Chessboard board = new Chessboard();
        board.solveAllQueens(0);
        board.printAllSolutions();
        System.out.println("Total Solutions: " + board.allSolutions.size());
    }
}






