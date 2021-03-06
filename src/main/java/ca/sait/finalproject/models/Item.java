
package ca.sait.finalproject.models;

/**
 *
 * @author Kingston
 */
public class Item {
    private int id;
    private int category;
    private String email;
    private String name;
    private double price;  

    public Item() {
    }

    public Item(int id, int category, String name, double price, String email) {
        this.id = id;
        this.category = category;
        this.email = email;
        this.name = name;
        this.price = price;
    }
    
        public Item(int category, String name, double price, String email) {
        this.category = category;
        this.email = email;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

}
