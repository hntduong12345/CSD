package Single_Linked_List;


public class Node {
    Book info;
    Node next;
    Node(){}
    Node(Book x, Node p)
    {
        info = x;
        next = p;
    }
    
    public static boolean compare(Book b1, Book b2){
        if(b1.getTitle().equalsIgnoreCase(b2.getTitle()))
            if(b1.getIsbn()==b2.getIsbn())
                if(b1.getPrice()==b2.getPrice())
                    return true;
        return false;
    }
}
