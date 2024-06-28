package test;

//import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class coin implements Serializable{
    String id;
    double price;

    public coin() {
    }
    
    public coin(String id, double price){
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return id+","+price;
    }
    
    
}

class FileTest extends ArrayList<coin>{
    public void addCoin(String id, double price){
        coin c = new coin(id, price);
        this.add(c);
    }
    
    public void loadFromFile(String fileName){
        if(this.size()>0)
            this.clear();
        
        try{
            File f = new File(fileName);
            if(!f.exists())
                return;
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream fo = new ObjectInputStream(fi);
            coin temp;
            
            while((temp=(coin)(fo.readObject()))!=null){
                this.add(temp);
            }
            fo.close(); fi.close();
        }catch(Exception e){
            if(e.getMessage()!=null)
                System.out.println(e.getMessage());
        }
    }
    
    public void saveToFile(String fileName){
        if(this.isEmpty()){
            System.out.println("Empty list.");
            return;
        }
            
        try{
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (coin aThi : this) {
                fo.writeObject(aThi);
            }
            
            fo.close(); f.close();;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void printCoin(){
        for(coin c : this)
            System.out.println(c);
    }
}

public class Test3 extends ArrayList<Integer>{
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        String str =null;
        int a = Integer.MIN_VALUE;
        FileTest ft = new FileTest();
//        ft.addCoin(str,1.4);
//        ft.addCoin("c2",a);
//        ft.saveToFile("coin.txt");

        ft.loadFromFile("coin.txt");
        ft.printCoin();
    }
}
