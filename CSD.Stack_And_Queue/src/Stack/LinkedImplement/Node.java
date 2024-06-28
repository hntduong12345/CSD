package Stack.LinkedImplement;

public class Node {

    public Object info;
    public Node next;

    Node(Object x) {
        this(x, null);
    }

    public Node(Object x, Node p) {
        info = x;
        next = p;
    }

    Node() {
    }
}
