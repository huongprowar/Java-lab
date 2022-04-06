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
    public int compareTo(Ordering t) {
        int result = t.ccode.compareTo(t.ccode);
        if (result == 0) {
            result = t.pcode.compareTo(t.pcode);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return this.ccode.equals(((Ordering) o).ccode)
                && this.pcode.equals(((Ordering) o).pcode);
    }
}
