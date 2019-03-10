import java.text.NumberFormat;
public class Node {
    Book info;
    Node left, right;

    public Node() {
    }

    public Node(Book info) {
        this.info = info;
        left = right = null;
    }
    
}
