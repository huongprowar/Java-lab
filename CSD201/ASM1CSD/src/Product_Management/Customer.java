package Product_Management;

public class Customer {

    private String ccode;
    private String cus_name;
    private String phone;

    public Customer() {
    }

    public Customer(String ccode, String name, String phone) {
        this.ccode = ccode;
        this.cus_name = name;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%6s | %20s | %10s", ccode, cus_name, phone);
    }
}
