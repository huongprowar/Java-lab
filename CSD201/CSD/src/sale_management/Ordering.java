package sale_management;

public class Ordering implements Comparable<Ordering> {

    private String pcode;
    private String ccode;
    private Integer quantity;

    public Ordering() {

    }

    public Ordering(String pcode, String ccode, Integer quantity) {
        this.pcode = pcode;
        this.ccode = ccode;
        this.quantity = quantity;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Ordering o) {
        int result = 0;
        result = this.getPcode().compareTo(o.getPcode());
        if (result == 0) {
            result = this.getCcode().compareTo(o.getCcode());
        }
        return result;
    }

    @Override
    public boolean equals(Object arg0) {
        return this.getCcode().equals(((Ordering) arg0).getCcode())
                && this.getPcode().equals(((Ordering) arg0).getPcode());
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %d", this.getPcode(), this.getCcode(), this.getQuantity());
    }
}
