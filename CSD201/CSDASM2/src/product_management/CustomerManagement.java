package product_management;

import csdasm2.Node;
import csdasm2.BSTree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CustomerManagement {

    BSTree tree;

    public CustomerManagement() {
        tree = new BSTree();
    }

    public void loadDataFromFile(String filename) {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                for (Object o : reader.lines().toArray()) {
                    String line = (String) o;
                    String[] tokens = line.split("\\|");

                    if (tokens.length == 5) {
                        tree.insert(new Customer(
                                tokens[0].trim(),
                                tokens[1].trim(),
                                tokens[2].trim()
                        ));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot open file");
        }
    }
    
        private void insert(Product data) {
        if (root == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else {
            node.setRight(insert(node.getRight(), data));
        }

        return node;
    }

    public void insertData() {
        Customer p = new Customer();

        p.setCcode(Input.getString("Enter customer code: ", (value) -> {
            Customer tmp = new Customer();
            tmp.setCcode(value);
            if (tree.contains(tmp)) {
                System.out.println("Thang nay da ton tai");
                return false;
            }
            return true;
        }));

        p.setCname(Input.getString("Enter customer name: "));
        p.setPhone(Input.getString("Enter phone: ", "\\d+"));

        tree.insert(p);
    }

    public void display() {
        tree.inorderTraversal((node) -> {
            System.out.println(node.getData());
        });
    }

    public void saveToFileInorder(String filename) {
        try {
            try (FileWriter fw = new FileWriter(new File(filename))) {
                tree.inorderTraversal((node) -> {
                    try {
                        fw.append(node.getData() + "\n");
                    } catch (Exception e) {
                    }
                });
            }
        } catch (Exception e) {
        }
    }

    public void searchByCode() {
        Customer tmp = new Customer();
        tmp.setCcode(Input.getString("Enter customer code: "));

        Node<Customer> node = tree.search(tmp);

        if (node == null) {
            System.out.println("Ko ton tai");
        } else {
            System.out.println(node.getData());
        }
    }

    public void deleteByCode() {
        Customer tmp = new Customer();
        tmp.setCcode(Input.getString("Enter customer code: "));

        tree.remove(tmp);
    }
}
