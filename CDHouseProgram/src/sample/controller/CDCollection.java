package sample.controller;

import sample.dtos.CD;
import sample.utils.Tools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class CDCollection extends HashMap<String, CD> implements I_Collection {

    private int cdCounter = 0; //The number of CDs in the list.

    //Add new CD.
    @Override
    public boolean add() {
        boolean result = false;
        //Input data.
        String id = Tools.getString("Enter CD's id: ", false);
        if (this.searchByID(id) != null) {
            System.out.println("The ID has  existed.");
            return false;
        }
        CD tempCD = new CD(id);
        if (tempCD.setInformation()) {
            this.put(id, tempCD);
            this.cdCounter++;
            result = true;
        }
        return result;
    }

    //Search CD by ID.
    public CD searchByID(String id) {
        CD tempCD = null;
        if (this.containsKey(id)) {
            tempCD = this.get(id);
        }
        return tempCD;
    }

    //Show the list of CD in the List.
    @Override
    public void display() {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        System.out.println("Number of CD in the list: " + this.cdCounter);
        for (String element : this.keySet()) {
            get(element).showInfo();
        }
    }

    //Update the CD's information (Except CD's id).
    @Override
    public boolean update() {
        boolean result = false;
        String id = Tools.getString("Enter CD's id: ", false);
        CD tempCD = searchByID(id);
        if (tempCD == null) {
            System.out.println("Not found!");
        } else {
            tempCD.updateInformation();
            result = true;
        }
        return result;
    }

    //Delete the CD.
    @Override
    public boolean delete() {
        boolean result = false;
        String id = Tools.getString("Enter CD's id to delete: ", false);
        CD tempCD = this.searchByID(id);
        if (tempCD == null) {
            System.out.println("Id not found.");
        } else {
            this.remove(id);
            this.cdCounter--;
            result = true;
        }
        return result;
    }

    //Save the list of CD to file.
    @Override
    public void saveToFile() {
        if (this.isEmpty()) { //Checking is the list empty?
            System.out.println("Empty List.");
            return;
        }
        try {
            File f = new File("CD.dat");
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (String x : this.keySet()) {
                pw.print(get(x).toString());
                pw.printf(".3f\n", get(x).getUnitPrice());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Search the CD by its title.
    @Override
    public CD serarchByTitle(String title) {
        CD tempCD = null;
        String id;
        for (String cd : this.keySet()) {
            if (get(cd).getTitle().equalsIgnoreCase(title)) {
                tempCD = get(cd);
                break;
            }
        }
        return tempCD;
    }

    //Load the list of CD from the file.
    @Override
    public void loadFromFile() {
        try {
            File f = new File("CD.dat");
            if (!f.exists()) { //Checking is the file exist?
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String detail;
            while ((detail = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(detail, ",");
                String id = stk.nextToken();
                String title = stk.nextToken();
                String collectionName = stk.nextToken();
                String type = stk.nextToken();
                int publishingYear = Integer.parseInt(stk.nextToken());
                double price = Double.parseDouble(stk.nextToken());

                //Create new CD from the information in file.
                CD temp = new CD(collectionName, type, title, price, id, publishingYear);
                this.put(id, temp); //Add the CD from file to system's list.
                this.cdCounter++;
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            if (this.isEmpty()) {
                System.out.println("Empty file.");
            } else {
                System.out.println(e);
            }
        }
    }

    //Sort the list of CD by title in ascending.
    public boolean sort() {
        List<CD> list = new ArrayList<>(this.values());
        Collections.sort(list);
        for (CD cd : list) {
            cd.showInfo();
        }
        return true;
    }
}
