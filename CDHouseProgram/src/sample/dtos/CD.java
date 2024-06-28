package sample.dtos;

import sample.utils.Tools;

public class CD implements Comparable<CD> {

    private String collectionName;
    private String type;
    private String title;
    private double unitPrice;
    private String id;
    private int publishingYear;

    //Constructor.
    public CD(String collectionName, String type, String title, double unitPrice, String id, int publishingYear) {
        this.collectionName = collectionName;
        this.type = type;
        this.title = title;
        this.unitPrice = unitPrice;
        this.id = id;
        this.publishingYear = publishingYear;
    }

    public CD(String id) {
        this.id = id;
    }

    public CD() {
    }

    //Getter and setter.
    public String getTitle() {
        return title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Set new information method.
    public boolean setInformation() {
        this.title = Tools.getString("Enter CD's title: ", false);
        this.type = Tools.cdType("Enter CD's type: (audio/video) ", false);
        this.collectionName = Tools.cdCollectionName("Enter CD's collection name: (game/movie/music) ", false);
        this.publishingYear = Tools.getInt("Enter CD's publishing year: ", false);
        this.unitPrice = Tools.getDouble("Enter CD's price: ", false);
        return true;
    }

    //Update information method.
    public boolean updateInformation() {
        String newTitle = Tools.getString("Enter CD's title: ", true);
        String newCollectionName = Tools.cdCollectionName("Enter CD's collection name: (game/movie/music) ", true);
        String newType = Tools.cdType("Enter CD's type: (audio/video) ", true);
        double newUnitPrice = Tools.getDouble("Enter CD's price: ", true);
        int newPublishingYear = Tools.getInt("Enter CD's pblishing year: ", true);

        if (newTitle != null) {
            setTitle(newTitle);
        }
        if (newCollectionName != null) {
            setCollectionName(newCollectionName);
        }
        if (newType != null) {
            setType(newType);
        }
        if (newUnitPrice != Double.MIN_VALUE) {
            setUnitPrice(newUnitPrice);
        }
        if (newPublishingYear != Integer.MIN_VALUE) {
            setPublishingYear(newPublishingYear);
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,", id, title, collectionName, type, publishingYear);
    }

    //Show CD's information.
    public void showInfo() {
        System.out.printf("ID: %-5s| title: %-18s| collection name: %-5s| type: %-6s| publishing year: %-5d| price: %.3f\n", id, title, collectionName, type, publishingYear, unitPrice);
    }

    //Comparing tool.
    @Override
    public int compareTo(CD o) {
        return this.title.compareTo(o.title);
    }
}
