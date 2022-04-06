package sale_management;

public class Product implements Comparable<Product> {

    private String code;
    private String name;
    private Integer quantity;
    private Integer saled;
    private Double price;

    public Product() {

    }

    public Product(String code, String name, Integer quantity, Integer saled, Double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public int compareTo(Product o) {
        return this.getCode().compareTo((o).getCode());
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %d | %d | %.2f", this.code, this.name, this.quantity, this.saled, this.price);
    }
}
