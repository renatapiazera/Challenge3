package main.java.com.product;

public class Product {

    private int id;
    private String name;
    private String description;
    private double value;

    public Product(int id, String name, String description, double value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{"
                + "\n  \"id\": " + id
                + ",\n  \"name\": \"" + name
                + "\",\n  \"description\": \"" + description + "\""
                + ",\n  \"value\": " + value + "\n}\n";
    }
}
