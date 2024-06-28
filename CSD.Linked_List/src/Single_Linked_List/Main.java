package Single_Linked_List;

import java.util.Scanner;


public class Main {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        MyList list1 = new MyList();
        list1.addToTail(new Book("F",6,60));
        list1.addToTail(new Book("B",2,20));
        list1.addToTail(new Book("A",1,10));
        list1.addToTail(new Book("C",3,30));
        list1.addToTail(new Book("E",5,50));
        list1.addToTail(new Book("D",4,40));
        
        MyList list2 = new MyList();
        list2.addToTail(new Book("Y",23,230));
        list2.addToTail(new Book("Z",24,240));
        list2.addToTail(new Book("W",21,210));
        list2.addToTail(new Book("X",22,220));
        
        MyList list3 = new MyList();
        list3.addToTail(new Book("F",6,60));
        list3.addToTail(new Book("B",2,20));
        list3.addToTail(new Book("A",1,10));
        list3.addToTail(new Book("C",3,30));
        list3.addToTail(new Book("E",5,50));
        list3.addToTail(new Book("D",4,40));
        
        MyList l1 = new MyList();
        l1.addToTail(new Book("Aa",1,10));
        l1.addToTail(new Book("Bb",2,20));
        l1.addToTail(new Book("Cc",3,30));
        
        MyList l2 = new MyList();
        l2.addToTail(new Book("m",9,90));
        l2.addToTail(new Book("n",8,80));
        
        int choice = 0;
        String[] mainMenu = {"Add.", "Delete.","Tranverse.","Search.","Sort.","Other methods."};
        do{
            String title;
            int isbn;
            double price;
            choice = getChoice(mainMenu);
            
            switch(choice){
                case 1:
                    String aMenu[] = {"Add to head.","Add to tail.","Add after.","Add before","Insert"};
                    int achoice = getChoice(aMenu);
                    System.out.println("Insert book information: ");
                     System.out.print("Insert title: ");
                    title = sc.nextLine();
                    System.out.print("Insert ISBN: ");
                    isbn = Integer.parseInt(sc.nextLine());
                    System.out.print("Insert price: ");
                    price = Double.parseDouble(sc.nextLine());
                    Book b = new Book(title,isbn,price);
                    if(achoice==1){
                        list1.addToHead(b);
                        break;
                    }
                    if(achoice==2)
                        list1.addToHead(b);
                    else{
                        Node x = new Node(b,null);
                        if(achoice==3){
                            list1.addAfter(x, b);
                            break;
                        }
                        if(achoice==4){
                            list1.addBefore(x, b);
                            break;
                        }
                        if(achoice==5)
                            list1.insert(new Book(title,isbn,price));
                    }
                    System.out.println("");
                    break;
                case 2:
                    String dMenu[] = {"Delete from head.","Delete from tail.","Delete after",
                                      "Delete the first node have given value.",
                                      "Delete an i-th node.","Delete node"};
                    int dChoice = getChoice(dMenu);
                    
                    if(dChoice==1)
                        list1.deleteFromHead();
                    if(dChoice==2)
                        list1.deleteFromTail();
                    if(dChoice==3 || dChoice==6){
                        System.out.println("Insert Node:");
                        System.out.print("Insert title: ");
                        title = sc.nextLine();
                        System.out.print("Insert ISBN: ");
                        isbn = Integer.parseInt(sc.nextLine());
                        System.out.print("Insert price: ");
                        price = Double.parseDouble(sc.nextLine());
                        Node p = new Node(new Book(title,isbn,price),null);
                        if(dChoice==3)
                            list1.deleteAfter(p);
                        else
                            list1.deleNode(p);
                    }
                    if(dChoice==4){
                        System.out.print("Insert book's isbn: ");
                        isbn = Integer.parseInt(sc.nextLine());
                        list1.dele(isbn);
                    }
                    if(dChoice==5){
                        System.out.print("Insert node position:");
                        int pos = Integer.parseInt(sc.nextLine());
                        list1.deleI(pos);
                    }
                    System.out.println("");
                    break;
                case 3:
                    list1.tranverse();
                    System.out.println("");
                    break;
                case 4:
                    System.out.print("Insert book's isbn: ");
                    isbn = Integer.parseInt(sc.nextLine());
                    System.out.println(list1.search(isbn).info);
                    System.out.println("");
                    break;
                case 5:
                    list1.sort();
                    System.out.println("");
                    break;
                case 6:
                    String oMenu[] = {"Count.","Max, Min, Sum, Average.","Attach list.","Merge List.",
                                      "To array.","Check is sorted.","Reverse.","Check contents."};
                    int oChoice = getChoice(oMenu);
                    
                    if(oChoice==1)
                        System.out.println("Number of books: "+list1.count());
                    if(oChoice==2){
                        System.out.println("Max: "+list1.max());
                        System.out.println("Min: "+list1.min());
                        System.out.println("Sum: "+list1.sum());
                        System.out.println("Average: "+list1.avg());
                    }
                    if(oChoice==3)
                        list1.attachList(list1, list3);
                    if(oChoice==4){
                        MyList temp = new MyList();
                        temp = temp.merge(list1, list2);
//                        temp = temp.merge(l1, l2);
                        temp.tranverse();
                    }
                    if(oChoice==5){
                        Book[] bList = list1.toArray();
                        for(Book temp : bList)
                            System.out.println(temp);
                    }
                    if(oChoice==6){
                        System.out.println("Check is list1 sorted? "+list1.sorted());
                        System.out.println("Check is l1 sorted? "+l1.sorted());
                    }
                    if(oChoice==7){
                        MyList temp2 = new MyList();
                        temp2 = temp2.reverse(l1);
                        temp2.tranverse();
                    }
                    if(oChoice==8){
                        System.out.println("Check contents of list1 and list2: "+ list1.checkContent(list1, list2));
                        System.out.println("Check contents of list1 and list3: "+ list1.checkContent(list1, list3));
                        System.out.println("Check contents of list2 and list3: "+ list1.checkContent(list2, list3));
                    }
            }
        }while(choice>0 && choice<7);
    }
    
    public static int getChoice(String[] mn){
        int choice;
        for(int i=0; i< mn.length; i++){
            System.out.println((i+1)+" - "+mn[i]);
        }
        System.out.println("Other - Quit.");
        System.out.print("User choice: ");
        choice = Integer.parseInt(sc.nextLine());
        return choice;
    }
}
