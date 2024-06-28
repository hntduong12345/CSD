/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Test2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//implementing HashMap  
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(6, "Tushar");
        hm.put(12, "Ashu");
        hm.put(5, "Zoya");
        hm.put(78, "Yash");
        hm.put(10, "Praveen");
        hm.put(67, "Boby");
        hm.put(1, "Ritesh");
        System.out.println("Before Sorting:");
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry map = (Map.Entry) iterator.next();
            System.out.println("Roll no:  " + map.getKey() + "     Name:   " + map.getValue());
        }
        Map<Integer, String> map = sortValues(hm);
        System.out.println("\n");
        System.out.println("After Sorting:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator2.next();
            System.out.println("Roll no:  " + me2.getKey() + "     Name:   " + me2.getValue());
        }
    }
//method to sort values  

    private static HashMap sortValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
//Custom Comparator  
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
//copying the sorted list in HashMap to preserve the iteration order  
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

}
