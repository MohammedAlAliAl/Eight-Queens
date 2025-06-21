/**
 * Enum representing the different types of chess pieces.
 */
public enum PieceType {
    /** The pawn: moves forward one square, with optional initial two-square move; captures diagonally. */
    PAWN,

    /** The rook: moves horizontally or vertically any number of squares. */
    ROOK,

    /** The knight: moves in an 'L' shape (2+1 squares); can jump over other pieces. */
    KNIGHT,

    /** The bishop: moves diagonally any number of squares. */
    BISHOP,

    /** The queen: moves horizontally, vertically, or diagonally any number of squares. */
    QUEEN,

    /** The king: moves one square in any direction; special move: castling. */
    KING
}
