package Components;

import java.lang.Cloneable;

public class Fruit implements Comparable<Fruit>{

    private int fruitid;
    private String fruitname;
    private String origin;
    private int quantity;
    private double price;

    public Fruit() {
    }

    public Fruit(int fruitid, String fruitname, String origin, int quantity, double price) {
        this.fruitid = fruitid;
        this.fruitname = fruitname;
        this.origin = origin;
        this.quantity = quantity;
        this.price = price;
    }

    public int getFruitid() {
        return fruitid;
    }

    public void setFruitid(int fruitid) {
        this.fruitid = fruitid;
    }

    public String getFruitname() {
        return fruitname;
    }

    public void setFruitname(String fruitname) {
        this.fruitname = fruitname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    @Override
    public int compareTo(Fruit t) {
        return (int) -(this.getQuantity() - t.getQuantity());
    }
}
