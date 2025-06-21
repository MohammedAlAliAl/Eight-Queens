import java.util.ArrayList;
import java.util.List;

public class Node {
    int row, col;
    Piece piece; // Optional
    List<Node> neighbors = new ArrayList<>();

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public String getPosition(){
        return "(" + row + "," + col + ")";
    }
}
