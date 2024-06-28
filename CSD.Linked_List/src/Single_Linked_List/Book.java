package Single_Linked_List;

public class Book implements Comparable{
    private String title;
    private int isbn;
    private double price;
    
    //Constructors.
    public Book() {
    }

    public Book(String title, int isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }
    
    //Getters and setters.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        Book b = (Book)o;
        if(this.isbn > b.isbn)
            return 1;
        else if(this.isbn < b.isbn)
            return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "title: "+this.title+", ISBN: "+this.isbn+", Price: "+this.price;
    }
    
}
