package sample.controller;

import java.util.ArrayList;

//Class for a menu.
public class Menu extends ArrayList<String> implements I_Menu {

    @Override
    public void addItem(String item) {
        add(item);
    }

    @Override
    public void showMenu() {
        for (String item : this) {
            System.out.println(item);
        }
    }

}
