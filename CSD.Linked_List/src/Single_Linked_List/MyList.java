package Single_Linked_List;


public class MyList {
    Node head, tail;
    MyList()
    {head = tail = null;}

    boolean isEmpty()
    {return (head==null);}

    void clear()
    {head=tail=null;}

    //1.Add to head.
    void addToHead(Book x)
    {
        if(isEmpty())
            head=tail= new Node(x,null);
        else
        {
            Node q = new Node(x,null);
            q.next=head;
            head = q;
        }
    }
    
    //2.Add to tail.
    void addToTail(Book x)
    {
        if (isEmpty())
            head=tail=new Node(x,null);
        else
        {
            Node q = new Node(x,null);
            tail.next=q;
            tail=q;
        }
    }
 
    //3.Add After.
    void addAfter(Node p, Book x)
    {
        if (isEmpty())
            head=tail=new Node(x,null);
        else
        {
            Node current = head;
            if(Node.compare(p.info, tail.info))
            {
                addToTail(x);
                return;
            }
            while(!Node.compare(current.info, p.info))
            {
                current = current.next;
                if(current.next==null)
                    break;
            }
            
            if (current.next==null && !Node.compare(p.info, tail.info))
            {
                System.out.println("Cannot find the node given.");
                return;
            }
            
            Node addedNode = new Node();
            addedNode.info=x;
            addedNode.next=current.next;
            current.next=addedNode;
        }
    }
    
    //4.Tranverse.
    void tranverse()
    {
        Node p = head;
        while(p!=null)
        {
            System.out.println(" "+p.info.toString());
            p=p.next;
        }
        System.out.println();
    }
    
    //5.Delete from head.
    int deleteFromHead()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            Node deleNode = head;
            head = head.next;
            return deleNode.info.getIsbn();
        }
        return 0;
    }
    
    //6.Delete from tail.
    int deleteFromTail()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            Node current = head;
            Node deleNode = tail;
            while(current.next.info!=tail.info)
                current = current.next;
            tail = current;
            tail.next = null;
            return deleNode.info.getIsbn();
        }
        return 0;
    }
    
    //7. Delete the node after the node p and return its info.
    int deleteAfter(Node p)
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            Node current = head;
            while (!Node.compare(current.info, tail.info))
            {
                if (Node.compare(current.info, p.info))
                {
                    int deleNode = current.next.info.getIsbn();
                    current.next = current.next.next;
                    return deleNode;
                }
                current = current.next;
            }
            
            if(current.next==null && Node.compare(current.info, p.info))
                System.out.println("There is nothing to delete.");
            else
                System.out.println("Cannot find the given node.");
        }
        return 0;
    }

    //8.Delele the first node whose info is equal to x.
    void dele(int x)
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            int result;
            Node current = head;
            while(current.next.info.getIsbn()!=x)
            {
                current = current.next;
                if (current.next==null)
                    break;
            }
            
            if (current.next==null && current.info.getIsbn()!=x)
            {
                System.out.println("Cannot find the Node having value "+x);
                return;
            }
            if (current.next==null && current.info.getIsbn()==x)
                result = deleteFromTail();
            else
            {
                current.next = current.next.next;
            }
        }
    }
    
    //9.Search and return the reference to the first node having given ISBN.
    Node search(int x)
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            Node current = head;
            while (current.info.getIsbn()!=x)
            {
                current = current.next;
                if (current.next==null)
                    break;
            }
            
            if (current.info.getIsbn()==x)
                return current;
            else
                return null;
        }
        return null;
    }
    
    //10.Count and return number of nodes in the list.
    int count()
    {
        int count = 1;
        if (isEmpty())
            head=tail=null;
        else
        {
            
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
                count++;
            }
        }
        return count;
    }
    
    //11.Delete an i-th node on the list. Besure that such a node exists.
    void deleI(int i)
    {
        if (isEmpty())
            head=tail=null;
        else
        {
            int deleNode;
            int numOfElement = count();
            int ordinalNum = 1;
            Node current = head;
            if (i == numOfElement){
                deleNode = deleteFromTail();
                return;
            }
            
            if(i == 1){
                deleteFromHead();
                return;
            }
            
            if (i < numOfElement && !Node.compare(current.info, tail.info))
            {
                while (ordinalNum!=i-1)
                {
                    current = current.next;
                    ordinalNum++;
                }
                current.next=current.next.next;
            }
            
            if (i > numOfElement)
                System.out.println("There is no "+i+"-th node in the list.");
        }
    }
    
    //12. void sort() - sort the list by ascending order of info.
    void sort()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            Book temp;
            Node current = head, index;
            
            while(current != null)
            {
                index=current.next;
                while(index != null)
                {
                    if(current.info.getPrice() > index.info.getPrice())
                    {
                        temp = current.info;
                        current.info = index.info;
                        index.info = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
    
    //13.Delete node p if it exists in the list.
    void deleNode(Node p)
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            Node current = head;
            while (!Node.compare(current.next.info, p.info))
            {
                current = current.next;
                if (current.next==null)
                    break;
            }
            
            if (current.next==null && !Node.compare(current.info, p.info))
            {
                System.out.println("Cannot find the given node.");
                return;
            }
            if (Node.compare(current.next.info, p.info))
                current.next = current.next.next;
            
        }
    }
    
    //14.Create and return array containing info of all nodes in the list.
    Book[] toArray()
    {
        if (isEmpty())
            head=tail=null;
        else
        {
            int numOfE = count();
            Book[] arr = new Book[numOfE];
            Node current = head;
            arr[0] = current.info;
            int i = 1;
            while (current.next!=null)
            {
                current = current.next;
                arr[i] = current.info;
                i++;
            }
            return arr;
        }
        return null;
    }
    //15. Merge two ordered singly linked lists of integers into one ordered list.
    MyList merge(MyList a, MyList b)
    {
        if(!a.sorted()||!b.sorted())
            return null;
        
        MyList temp = new MyList();
        Node aCurrent = a.head;
        Node bCurrent = b.head;
        while(aCurrent!=null && bCurrent!=null)
        {
            if(aCurrent.info.getIsbn()<bCurrent.info.getIsbn())
            {
                temp.addToTail(aCurrent.info);
                aCurrent = aCurrent.next;
            }
            else
            {
                temp.addToTail(bCurrent.info);
                bCurrent = bCurrent.next;
            }
        }
            if(aCurrent==null)
            {
                while(bCurrent!=null)
                {
                    temp.addToTail(bCurrent.info);
                    bCurrent = bCurrent.next;
                }
                return temp;
            }
            if(bCurrent==null)
            {
                while(aCurrent!=null)
                {
                    temp.addToTail(aCurrent.info);
                    aCurrent = aCurrent.next;
                }
                return temp;
            }
        return temp;
    }
    
    //16. void addBefore(Node p, int x) - add a node with value x before the node p.
    void addBefore(Node p, Book x)
    {
        if (isEmpty())
            head=tail=null;
        else
        {   
            Node current = head;
            if(Node.compare(p.info, head.info))
            {
                addToHead(x);
                return;
            }
            
            while(!Node.compare(current.next.info, p.info))
            {
                current = current.next;
                if(current.next==null)
                    break;
            }
            
            if (current.next==null && !Node.compare(p.info, tail.info))
            {
                System.out.println("Cannot find the node given.");
                return;
            }
            
            Node addedNode = new Node();
            addedNode.info=x;
            addedNode.next=current.next;
            current.next=addedNode;
        }
    }
    
    //17. Attach a singly linked list to the end of another singly linked list.
    void attachList(MyList a, MyList b)
    {
        Node aCurrent = a.head;
        while(aCurrent!=null)
        {
            b.addToTail(aCurrent.info);
            aCurrent = aCurrent.next;
        }
    }
    
    //18.Find and return the maximum value in the list.
    double max()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            double max=head.info.getPrice();
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
                if(max<current.info.getPrice())
                    max = current.info.getPrice();
            }
            return max;
        }
        return 0;
    }
    
    //19.Find and return the minimum value in the list.
    double min()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            double min=head.info.getPrice();
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
                if(min>current.info.getPrice())
                    min = current.info.getPrice();
            }
            return min;
        }
        return 0;
    }
    
    //20.Return the sum of all values in the list.
    double sum()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            double sum=head.info.getPrice();
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
                sum += current.info.getPrice();
            }
            return sum;
        }
        return 0;
    }
    
    //21.Return the average of all values in the list.
    double avg()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            double sum=head.info.getPrice();
            int count = 1;
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
                sum += current.info.getPrice();
                count++;
            }
            return sum/(double)count;
        }
        return 0;
    }
    
    //22.Check and return true if the list is sorted, return false if the list is not sorted.
    boolean sorted()
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            Node current = head;
            boolean check = true;
            //Check sorted in ascending.
            while(current.next!=null)
            {
                if (current.info.getPrice() > current.next.info.getPrice())
                {
                    check = false;
                    break;
                }
                current = current.next;
            }
            
            if(check) return true;
            
            //Check sorted in descending.
            while(current.next!=null)
            {
                if (current.info.getPrice() < current.next.info.getPrice())
                {
                    check = false;
                    break;
                }
                current = current.next;
            }
            if(check) return true;
        }
        return false;
    }
    
    //23.Insert node with value x into sorted list so that the new list is sorted.
    void insert(Book x)
    {
        if(isEmpty())
            head=tail=null;
        else
        {
            boolean check = sorted();
            if (!check)
                System.out.println("Error. The list is not sorted.");
            else
            {
                addToTail(x);
                sort();
            }
        }
    }
    
//24. Reverse a singly linked list using only one pass through the list.
    MyList reverse(MyList a)
    {
        MyList temp = new MyList();
        Node current = a.head;
        while(current!=null)
        {
            temp.addToHead(current.info);
            current = current.next;
        }
        return temp;
    }
    
//25. Check whether two singly linked list have the same contents.
    boolean checkContent(MyList a, MyList b)
    {
        if(a.count()!=b.count())
            return false;
        Node aCurrent = a.head;
        Node bCurrent = b.head;
        
        while(aCurrent!=null && bCurrent!=null)
        {
            if(!Node.compare(aCurrent.info, bCurrent.info))
                return false;
            
            aCurrent = aCurrent.next;
            bCurrent = bCurrent.next;
        }
        return true;
    }
}