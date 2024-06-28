package BinaryTree;

public class Node {

    int info;
    Node left, right;

    Node() {
    }

    Node(int x, Node p, Node q) {
        info = x;
        left = p;
        right = q;
    }

    Node(int x) {
        this(x, null, null);
    }
}
