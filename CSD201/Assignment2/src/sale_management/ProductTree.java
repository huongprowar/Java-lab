package sale_management;

import java.io.BufferedReader;
import java.io.FileWriter;

import binary_search_tree.*;
import utilities.Input;

public class ProductTree extends BinarySearchTree<Product> {
    public Node<Product> findProductPCode(String code) {
        Product tmp = new Product();
        tmp.setCode(code);
        return search(tmp);
    }

    public void addProduct() {
        Product product = new Product();

        product.setCode(Input.getString("Enter product code: ", (code) -> {
            if (findProductPCode(code) != null) {
                System.out.println("Product code already exists.");
                return false;
            }

            return true;
        }));

        product.setName(Input.getString("Enter product name: "));

        product.setQuantity(Input.getInteger("Enter product quantity: ", (quantity) -> {
            if (quantity < 0) {
                System.out.println("Product quantity must be greater than 0.");
                return false;
            }

            return true;
        }));

        product.setSaled(Input.getInteger("Enter product saled: ", (saled) -> {
            if (saled < 0) {
                System.out.println("Product saled must be greater than 0.");
                return false;
            }

            if (saled > product.getQuantity()) {
                System.out.println("Product saled must be less than quantity.");
                return false;
            }

            return true;
        }));

        product.setPrice(Input.getDouble("Enter product price: ", (price) -> {
            if (price < 0) {
                System.out.println("Price must be greater than 0.");
                return false;
            }

            return true;
        }));

        insert(product);
    }

    public void deleteByCode() {
        Product product = new Product();

        product.setCode(Input.getString("Enter product code: ", (code) -> {
            if (findProductPCode(code) == null) {
                System.out.println("Product code does not exist.");
                return false;
            }

            return true;
        }));

        remove(product);
    }

    public boolean loadDataFromFile(String filename) {
        try {
            try (BufferedReader br = new BufferedReader(new java.io.FileReader(filename))) {
                clear();
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split("\\|");

                    if (data.length == 5) {
                        insert(new Product(
                                data[0].trim(),
                                data[1].trim(),
                                Integer.parseInt(data[2].trim()),
                                Integer.parseInt(data[3].trim()),
                                Double.parseDouble(data[4].trim())));
                    }
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    public interface ProductTraverseRule<T extends Comparable<T>> {
        void traverse(Node<T> node, TraversalCallback<T> callback);
    }

    public boolean saveDataToFile(String filename, ProductTraverseRule<Product> rule) {
        try {
            try (FileWriter fw = new FileWriter(filename)) {
                rule.traverse(getRoot(), (node) -> {
                    try {
                        fw.append(node.toString() + "\n");
                    } catch (Exception e) {
                        // System.out.println("Error: " + e.getMessage());
                    }
                });
            }
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void display(ProductTraverseRule<Product> rule) {
        rule.traverse(getRoot(), (node) -> {
            System.out.println(node.toString());
        });
    }

    public void searchByCode() {
        String code = Input.getString("Enter product code: ");
        Node<Product> node = findProductPCode(code);

        if (node != null) {
            System.out.println(node.toString());
        } else {
            System.out.println("Product code does not exist.");
        }
    }

    public void countNumberOfProducts() {
        System.out.println("Number of products: " + size());
    }
}
