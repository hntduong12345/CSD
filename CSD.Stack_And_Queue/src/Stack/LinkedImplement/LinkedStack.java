package Stack.LinkedImplement;

import java.util.EmptyStackException;

public class LinkedStack {

    protected Node head;

    public LinkedStack() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void push(Object x) {
        head = new Node(x, head);
    }

    Object top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.info;
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object x = head.info;
        head = head.next;
        return x;
    }

    public void tranverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println("");
    }

    public LinkedStack convertDecToBin(int x) {
        LinkedStack ls = new LinkedStack();

        do {
            ls.push(x % 2);
            x /= 2;
        } while (x / 2 != 0);
        return ls;
    }
}
