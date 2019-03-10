import java.text.NumberFormat;
import java.util.LinkedList;

public class MyQueue {
    LinkedList<Node> LL;

    public MyQueue() {
        LL = new LinkedList<Node>();
    }

    public MyQueue(LinkedList<Node> LL) {
        this.LL = LL;
    }
    void clear(){
        LL.clear();
    }
    boolean isEmpty(){
        return LL.isEmpty();
    }
    void enqueue(Node p){
        LL.addLast(p);
    }
    Node dequeue(){
        if(LL.isEmpty()) return null;
        return LL.removeFirst();
    }
    Node front(){
        if(LL.isEmpty()) return null;
        return LL.getFirst();
    }
}
