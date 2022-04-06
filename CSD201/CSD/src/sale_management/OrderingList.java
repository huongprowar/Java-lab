package sale_management;

import java.io.BufferedReader;
import java.io.FileWriter;

import linked_list.LinkedList;
import linked_list.Node;
import utilities.Input;

public class OrderingList extends LinkedList<Ordering> {
    public OrderingList() {

    }

    public boolean loadDataFromFile(String filename) {
        try {
            try (BufferedReader br = new BufferedReader(new java.io.FileReader(filename))) {
                clear();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");

                    if (data.length == 3) {
                        addTail(new Ordering(data[0].trim(), data[1].trim(), Integer.parseInt(data[2])));
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean saveDataToFile(String filename) {
        try {
            try (FileWriter fw = new FileWriter(filename)) {
                Node<Ordering> it = getHead();
                while (it != null) {
                    fw.write(it.getData().toString() + "\n");
                    it = it.getNext();
                }
            }
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void addOrdering(ProductTree productList, CustomerList customerList) {
        Ordering Ordering = new Ordering();

        Ordering.setCcode(Input.getString("Enter customer code: ", (value) -> {
            if (customerList.findCustomerByCode(value) == null) {
                System.out.println("Customer code is not exist");
                return false;
            }
            return true;
        }));

        Ordering.setPcode(Input.getString("Enter product code: ", (value) -> {
            if (productList.findProductByCode(value) == null) {
                System.out.println("Product code is not exist");
                return false;
            }
            return true;
        }));

        Ordering.setQuantity(Input.getInteger("Enter quantity: ", (value) -> {
            if (value <= 0) {
                System.out.println("Quantity must be greater than 0");
                return false;
            }

            if (productList.findProductByCode(Ordering.getPcode()).getData().getQuantity() < value) {
                System.out.println("Quantity is greater than available quantity");
                return false;
            }
            return true;
        }));

        this.addTail(Ordering);
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return reduce((result, value) -> result + value.toString() + "\n", "");
    }

    public void sort() {
        sort((a, b) -> {
            if (a.getCcode().equals(b.getCcode())) {
                return a.getPcode().compareTo(b.getPcode());
            }
            return a.getCcode().compareTo(b.getCcode());
        });
    }
}
