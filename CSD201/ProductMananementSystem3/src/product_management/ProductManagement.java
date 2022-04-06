/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */
package product_management;

import binary_search_tree.Node;
import binary_search_tree.Tree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import utilities.Input;

/**
 *
 * @author yuyu
 */
public class ProductManagement {

    private Tree<Product> tree;

    public Tree<Product> getTree() {
        return tree;
    }

    
    
    public ProductManagement() {
        tree = new Tree<>();
    }

    public void loadDataFromFile(String filename) {
        try {
            tree.clear();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                for (Object o : reader.lines().toArray()) {
                    String line = (String) o;
                    String[] tokens = line.split("\\|");

                    if (tokens.length == 5) {
                        tree.insert(new Product(
                                tokens[0].trim(),
                                tokens[1].trim(),
                                Integer.parseInt(tokens[2].trim()),
                                Integer.parseInt(tokens[3].trim()),
                                Double.parseDouble(tokens[4].trim())
                        ));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot open file");
        }
    }

    public void insertData() {
        Product p = new Product();

        p.setPcode(Input.getString("Enter product code: ", (value) -> {
            Product tmp = new Product();
            tmp.setPcode(value);
            if (tree.contains(tmp)) {
                System.out.println("Thang nay da ton tai");
                return false;
            }
            return true;
        }));

        p.setPname(Input.getString("Enter product name: "));

        p.setQuantity(Input.getIntegerInclusive("Enter quantity: ", 0, Integer.MAX_VALUE));

        p.setSaled(Input.getIntegerInclusive("Enter saled: ", 0, p.getQuantity()));

        p.setPrice(Input.getDoubleInclusive("Enter price: ", 0, Double.POSITIVE_INFINITY));

        tree.insert(p);
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

    public void displayBreadthFirst() {
        tree.breadthFirstTraversal((node) -> {
            System.out.println(node.getData());
        });
    }

    public void display() {
        tree.inorderTraversal((node) -> {
            System.out.println(node.getData());
        });
    }

    public void searchByCode() {
        Product tmp = new Product();
        tmp.setPcode(Input.getString("Enter product code: "));

        Node<Product> node = tree.search(tmp);

        if (node == null) {
            System.out.println("Ko ton tai");
        } else {
            System.out.println(node.getData());
        }
    }

    public void deleteByCode() {
        Product tmp = new Product();
        tmp.setPcode(Input.getString("Enter product code: "));

        tree.remove(tmp);
    }

    public void countNumberOfProduct() {
        ArrayList<Product> products = new ArrayList<>();
        tree.inorderTraversal((node) -> {
            products.add(node.getData());
        });

        System.out.println("So luong: " + products.size());
    }

    public void selfBalance() {
        tree.balance();
    }
}
