package sample.controller;

import sample.dtos.CD;

public interface I_Collection {

    public boolean add();

    public CD serarchByTitle(String title);

    public void display();

    public boolean update();

    public boolean delete();

    public void saveToFile();
    
    public void loadFromFile();
    
    public boolean sort();
}
