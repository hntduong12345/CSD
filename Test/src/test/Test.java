package test;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
    //duonghntse171581
    //BeK5zKha

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, TestContainer> hs = new HashMap<String, TestContainer>();
        hs.put("001", new TestContainer("001", "A", 1));
        hs.put("002", new TestContainer("002", "B", 2));
        hs.put("003", new TestContainer("003", "C", 3));
        hs.put("004", new TestContainer("004", "D", 4));

        String name = sc.nextLine();
        TestContainer tempTC = null;
        for(String num : hs.keySet())
        {
            if(hs.get(num).getName().equalsIgnoreCase(name))
            {
                tempTC=hs.get(num);
                break;
            }
        }
        
        
        if(tempTC==null)
            System.out.println("Not found.");
        else
            System.out.println(tempTC.toString());
        
//        for(String item : hs.keySet())
//            System.out.println(hs.get(item).toString());
    }

}
