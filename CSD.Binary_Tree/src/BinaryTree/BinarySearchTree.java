package BinaryTree;

import java.util.*;

public class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void clear() {
        root = null;
    }

    Node search(int x) {
        Node p = root;
        boolean cont = true;
        while (cont) {
            if (p == null) {
                return null;
            }
            if (p.info == x) {
                return p;
            }
            if (p.info < x) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return p;
    }

    void insert(int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        if (search(x) != null) {
            System.out.println("Value already exist!");
        } else {
            Node p = root;
            boolean cont = true;
            while (cont) {
                if (p.left == null && x < p.info) {
                    p.left = new Node(x);
                    break;
                }
                if (p.right == null && x > p.info) {
                    p.right = new Node(x);
                    break;
                }
                if (p.info < x) {
                    p = p.right;
                } else {
                    p = p.left;
                }
            }
        }
    }

    void breadth() {
        if (root == null) {
            System.out.println("Empty Tree!");
        } else {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                System.out.print(temp.info + " ");

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    void preorder(Node p) {
        if (p == null) {
            return;
        }

        System.out.print(p.info + " ");

        preorder(p.left);

        preorder(p.right);
    }

    void inorder(Node p) {
        if (p == null) {
            return;
        }

        inorder(p.left);

        System.out.print(p.info + " ");

        inorder(p.right);
    }

    void postorder(Node p) {
        if (p == null) {
            return;
        }

        postorder(p.left);

        postorder(p.right);

        System.out.print(p.info + " ");
    }

    int count() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            count++;

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return count;
    }

    void delete(int x) {
        if (isEmpty()) {
            System.out.println("Empty tree.");
            return;
        }
        if (search(x) == null) {
            System.out.println("Can't find the given node!");
            return;
        }
        Node p = root;
        Node temp = root;
        boolean cont = true;

        if (p.info == x) {
            root = null;
        }
        while (cont) {
            //Move to next node to find the delete node.
            if (p.info < x) {
                p = p.right;
            }
            if (p.info > x) {
                p = p.left;
            }

            //Delete Node.
            if (p.info == x) {
                if (p.left == null && p.right == null) {
                    temp.left = null;
                    temp.right = null;
                }
                if (p.left != null && p.right == null) {
                    temp.left = p.left;
                }
                if (p.right != null && p.left == null) {
                    temp.right = p.right;
                }
                if (p.left != null && p.right != null) {
                    p.left.right = p.right;
                    temp.left = p.left;
                }
                cont = false;
            }

            //Set temp node right behide p node.
            temp = p;
        }
    }

    Node min() {
        if (isEmpty()) {
            return null;
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    Node max() {
        if (isEmpty()) {
            return null;
        }
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    int sum() {
        if (isEmpty()) {
            return 0;
        }
        int sum = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            sum += temp.info;

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return sum;
    }

    double avg() {
        return (double) sum() / (double) count();
    }

    int mystery(Node x) {
        if (x == null) {
            return 0;
        } else {
            return Math.max(mystery(x.left), mystery(x.right));
        }
    }

    void isHeap() {
        if (isEmpty()) {
            System.out.println("Empty tree!");
            return;
        }

        if (isMaxHeap()) {
            System.out.println("Yes!");
        } else if (isMinHeap()) {
            System.out.println("Yes!");
        } else {
            System.out.println("NOPE!");
        }
    }

    boolean isMaxHeap() {
        Node p = root;
        while (p != null) {
            if (p.left != null) {
                return false;
            } else {
                p = p.right;
            }
        }
        return true;
    }

    boolean isMinHeap() {
        Node p = root;
        while (p != null) {
            if (p.right != null) {
                return false;
            } else {
                p = p.left;
            }
        }
        return true;
    }
}
