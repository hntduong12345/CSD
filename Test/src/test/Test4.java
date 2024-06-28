/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

class toy{
    String ID;
    int price;

    public toy(String ID, int price) {
        this.ID = ID;
        this.price = price;
    }

    @Override
    public String toString() {
        return ID+", "+price;
    }
}

public class Test4 {
    public static void main(String[] args){
        toy t1 = new toy("1",1);
        toy t2 = new toy("1",1);
        System.out.println(t1==t2);
    }
}
