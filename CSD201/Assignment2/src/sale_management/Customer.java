package sale_management;

public class Customer implements Comparable<Customer> {

    private String code;
    private String name;
    private String phone;

    public Customer() {

    }

    public Customer(String code, String name, String phone) {
        this.code = code;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Customer o) {
        return this.code.compareTo(o.getCode());
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s", this.code, this.name, this.phone);
    }

    @Override
    public boolean equals(Object obj) {
        // equal by code
        return this.code.equals(((Customer) obj).getCode());
    }
}
