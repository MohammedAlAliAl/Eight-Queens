
/**
 * Represents a single cell (or square) on the chessboard.
 * Each node knows its position (row and column) and can hold a Piece.
 */
public class Node {
    int row, col;
    Piece piece;

/**
 * Constructs a Node with specified row and column indices.
 *
 * @param row the row index of this node
 * @param col the column index of this node
 */
public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

}
