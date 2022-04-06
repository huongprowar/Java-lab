
package product_management;

public class Customer implements Comparable<Customer> {

    private String ccode;
    private String cname;
    private String phone;

    public Customer() {
    }

    public Customer(String ccode, String cname, String phone) {
        this.ccode = ccode;
        this.cname = cname;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Customer t) {
        return this.ccode.compareTo(t.ccode);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s", ccode, cname, phone);
    }

}
