package test;

import java.util.Scanner;

public class PatternTest {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        String pattern = "^p\\d{3}$";
        String text = sc.nextLine();
        
        if(text.matches(pattern)){
            System.out.println("OK");
        }
        else{
            System.out.println("Ah shit");
        }
    }
}
