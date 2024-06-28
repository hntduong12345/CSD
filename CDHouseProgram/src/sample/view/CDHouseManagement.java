package sample.view;

import sample.utils.Tools;
import sample.controller.Menu;
import sample.controller.CDCollection;
import sample.dtos.CD;

public class CDHouseManagement {

    public static void main(String[] ars) {
        //Setup Menu.
        Menu menu = new Menu();
        menu.add("~~~~~~CD House Program.~~~~~~~");
        menu.add("1.Add CD to catalog.");
        menu.add("2.Search CD by title.");
        menu.add("3.Display the catalog.");
        menu.add("4.Update CD.");
        menu.add("5.Save account to file.");
        menu.add("6.Print list CDs from file.");
        menu.add("Others - Quit");
        menu.add("____________________________");
        CDCollection cdMap = new CDCollection();
        int choice;
        do { //Do activities.
            menu.showMenu();
            choice = Tools.getInt("Select your choice: ", 1, menu.size() - 2);
            switch (choice) {
                case 1:
                    if (cdMap.add()) {
                        System.out.println("Successfull!");
                    } else {
                        System.out.println("Unsuccessful!");
                    }
                    System.out.println("");
                    break;
                case 2:
                    String title = Tools.getString("Enter cd's title to search: ", false);
                    CD temp = cdMap.serarchByTitle(title);
                    if (temp != null) {
                        temp.showInfo();
                    } else {
                        System.out.println("Error. CD cannot found.");
                    }
                    System.out.println("");
                    break;
                case 3:
                    cdMap.display();
                    System.out.println("");
                    break;
                case 4:
                    Menu subMenu = new Menu();
                    int uChoice;
                    subMenu.add("4.Update CD:");
                    subMenu.add("\t1.Update CD.");
                    subMenu.add("\t2.Delete CD.");
                    subMenu.showMenu();
                    uChoice = Tools.getInt("Select your choice: ", 1, subMenu.size() - 1);
                    if (uChoice == 1) {
                        boolean updateResult = cdMap.update();
                        if (updateResult) {
                            System.out.println("Successful!");
                        } else {
                            System.out.println("Unsuccessful!");
                        }
                    } else {
                        boolean deleteResult = cdMap.delete();
                        if (deleteResult) {
                            System.out.println("Successful!");
                        } else {
                            System.out.println("Unsuccessful!");
                        }
                    }
                    if (!Tools.askBackToMenu()) {
                        choice = 7;
                    }
                    System.out.println("");
                    break;
                case 5:
                    cdMap.saveToFile();
                    if (!Tools.askBackToMenu()) {
                        choice = 7;
                    }
                    System.out.println("");
                    break;
                case 6:
                    cdMap.loadFromFile();
                    cdMap.sort();
                    if (!Tools.askBackToMenu()) {
                        choice = 7;
                    }
                    System.out.println("");
                    break;
            }
        } while (choice != 7);
    }
}
