package Queue.LinkedListImplement;

public class MyQueue {

    protected Node head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    Object front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return head.info;
    }

    public Object dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        Object x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return x;
    }

    void enqueue(Object x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }

    public void tranverse() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
        System.out.println("");
    }
}
