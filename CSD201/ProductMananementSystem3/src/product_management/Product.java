/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package product_management;

/**
 *
 * @author yuyu
 */
public class Product implements Comparable<Product> {

    private String pcode;
    private String pname;
    private Integer quantity;
    private Integer saled;
    private Double price;

    public Product() {
    }

    public Product(String pcode, String pname, Integer quantity, Integer saled, Double price) {
        this.pcode = pcode;
        this.pname = pname;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSaled() {
        return saled;
    }

    public void setSaled(Integer saled) {
        this.saled = saled;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product t) {
        return this.pcode.compareTo(t.pcode);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %d | %d | %f", pcode, pname, quantity, saled, price);
    }
}
