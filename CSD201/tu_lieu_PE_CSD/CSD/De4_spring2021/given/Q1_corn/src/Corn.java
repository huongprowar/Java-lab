// ======= DO NOT EDIT THIS FILE ============

class Corn {

    String code;
    int type, price;

    Corn() {
    }

    Corn(String xCode, int xType, int xPrice) {
        code = xCode;
        type = xType;
        price = xPrice;
    }

    public String toString() {
        return ("(" + code + "," + type + "," + price + ")");
    }
}
