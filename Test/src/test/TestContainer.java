package test;


public class TestContainer implements Comparable<TestContainer>{
    private String id;
    private String name;
    private int number;

    public TestContainer(String id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public TestContainer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "TestContainer{" + "id=" + id + ", name=" + name + ", number=" + number + '}';
    }

    @Override
    public int compareTo(TestContainer o) {
        return this.name.compareToIgnoreCase(o.name);
    }
    
    
    
}
