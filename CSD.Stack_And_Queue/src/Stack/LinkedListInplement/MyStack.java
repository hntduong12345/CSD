package Stack.LinkedListInplement;

import java.util.*;

public class MyStack {

    LinkedList h;

    MyStack() {
        h = new LinkedList();
    }

    boolean isEmpty() {
        return h.isEmpty();
    }

    void push(Object x) {
        h.add(x);
    }

    Object pop() {
        if (isEmpty()) {
            return null;
        }
        return h.removeLast();
    }
}
