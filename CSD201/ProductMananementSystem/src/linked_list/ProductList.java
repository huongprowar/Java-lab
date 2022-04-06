/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

/**
 *
 * @author PC
 */
import product_management.Product;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class ProductList {

    private ProductNode head, tail;

    public ProductList() {
    }

    public ProductList(ProductNode head, ProductNode tail) {
        this.head = head;
        this.tail = tail;
    }

    public void clear() {
        head = tail = null;
    }

    public void addTail(Product data) {
        ProductNode node = new ProductNode();
        node.data = data;
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void addProductToTheEnd() {
        Scanner sc = new Scanner(System.in);

        System.out.print("pcode: ");
        String pcode = sc.nextLine();

        if (findProductByCode(pcode) != null) {
            System.out.println("Da ton tai!");
            return;
        }

        System.out.print("pro_name: ");
        String pro_name = sc.nextLine();

        System.out.print("quantity: ");
        int quantity = sc.nextInt();

        System.out.print("saled: ");
        int saled = sc.nextInt();

        System.out.print("price: ");
        double price = sc.nextDouble();

        addTail(new Product(pcode, pro_name, quantity, saled, price));

        System.out.println("Them thanh cong!");
    }

    public ProductNode findProductByCode(String pcode) {
        ProductNode it = head;
        if (head == null && tail == null) {
            return null;
        }
        while (it != null) {
            if (it.data.getPcode().equals(pcode)) {
                return it;
            }
            it = it.next;
        }
        return null;
    }

    public void remove(ProductNode node) {
        if (node == null) {
            return;
        }
        if (node == tail) {
            ProductNode it = head;
            ProductNode previousTail = null;
            while (it.next != null) {
                previousTail = it;
                it = it.next;
            }
            tail = previousTail;
            tail.next = null;
        } else {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }

    public void changeQuantityByPcode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("pcode: ");
        String code = sc.nextLine();
        ProductNode pNode = findProductByCode(code);
        if (pNode != null) {
            pNode.data.setQuantity(9);
        }
    }

    public void deleteByPcode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("pcode: ");
        String code = sc.nextLine();
        ProductNode pNode = findProductByCode(code);
        remove(pNode);
        System.out.println("Xoa thanh cong!");
    }

    public void display() {
        ProductNode it = head;
        System.out.printf("%6s | %20s | %10s | %10s | %6s | %s\n", "code", "pro_name", "quantity", "saled", "price", "value");
        while (it != null) {
            System.out.printf("%6s | %20s | %10s | %10d | %6f | %f\n",
                    it.data.getPcode(),
                    it.data.getPname(),
                    it.data.getQuantity(),
                    it.data.getSaled(),
                    it.data.getPrice(),
                    it.data.getPrice() * it.data.getSaled());
            it = it.next;
        }
    }

    public void saveDataToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            ProductNode it = head;
            while (it != null) {
                String line = String.format(Locale.US, "%6s | %20s | %10d | %10d | %6.lf\n",
                        it.data.getPcode(),
                        it.data.getPname(),
                        it.data.getQuantity(),
                        it.data.getSaled(),
                        it.data.getPrice());
                fw.append(line);
                it = it.next;
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Loi khi save file!");
        }
    }

    public void loadDataFromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));

            sc.useLocale(Locale.US);

            while (sc.hasNext()) {
                String line = sc.nextLine();

                String[] tokens = line.split("\\|");

                if (tokens.length == 5) {
                    addTail(new Product(
                            tokens[0].trim(), tokens[1].trim(),
                            Integer.parseInt(tokens[2].trim()),
                            Integer.parseInt(tokens[3].trim()),
                            Double.parseDouble(tokens[4].trim()))
                    );
                }
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Loi khi load data!");
        }
    }

    public void searchByCode() {
        Scanner sc = new Scanner(System.in);
        String code = sc.nextLine();
        ProductNode pNode = findProductByCode(code);
        if (pNode != null) {
            System.out.printf("Found: %6s | %20s | %10d | %10d | %6.1f | %.1f\n",
                    pNode.data.getPcode(),
                    pNode.data.getPname(),
                    pNode.data.getQuantity(),
                    pNode.data.getSaled(),
                    pNode.data.getPrice(),
                    pNode.data.getPrice() * pNode.data.getSaled()
            );
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    private int compare(ProductNode a1, ProductNode a2) {
        if (a1.data.getSaled() == a2.data.getSaled()) {
            return a1.data.getPcode().compareTo(a2.data.getPcode());
        }
        return a1.data.getSaled() - a2.data.getSaled() > 0 ? 1 : 0;
    }

    public void sortBySaled() {
        while (true) {
            boolean check = true;
            ProductNode tmp = head;
            while (tmp.next != null) {
                if (compare(tmp, tmp.next) > 0) {
                    Product tmpnode = tmp.data;
                    tmp.data = tmp.next.data;
                    tmp.next.data = tmpnode;
                    check = false;
                }
                tmp = tmp.next;
            }
            if (check) {
                break;
            }
        }
    }

    public void sortByProductCode() {
        while (true) {
            boolean check = true;
            ProductNode tmp = head;
            while (tmp.next != null) {
                if (compare(tmp, tmp.next) > 0) {
                    Product tmpnode = tmp.data;
                    tmp.data = tmp.next.data;
                    tmp.next.data = tmpnode;
                    check = false;
                }
                tmp = tmp.next;
            }
            if (check) {
                break;
            }
        }
    }

    public void addAfterPositionK() {
        Scanner sc = new Scanner(System.in);
        System.out.println("pcode: ");
        String pcode = sc.nextLine();
        if (findProductByCode(pcode) != null) {
            System.out.println("Da ton tai!");
            return;
        }
        System.out.print("pro_name: ");
        String pro_name = sc.nextLine();

        System.out.print("quantity: ");
        int quantity = sc.nextInt();

        System.out.print("saled: ");
        int saled = sc.nextInt();

        System.out.print("price: ");
        double price = sc.nextDouble();

        System.out.print("position: ");
        int k = sc.nextInt();
        if (k < 0) {
            System.out.println("error!");
            return;
        }
        ProductNode tmp = head;
        while (tmp != null) {
            if (k == 0) {
                break;
            }
            k--;
            tmp = tmp.next;
        }
        Product data = new Product(pcode, pro_name, quantity, saled, price);
        if (tmp == null) {
            System.out.println("Nhap ngoai khoang!");
        } else {
            if (tmp == tail) {
                addTail(data);
            } else {
                ProductNode node = new ProductNode(data);
                node.next = tmp.next;
                tmp.next = node;
            }
            System.out.println("Them thanh cong!");
        }
    }

    public void removeAfterXCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("pcode: ");
        String code = sc.nextLine();
        ProductNode pNode = findProductByCode(code);
        remove(pNode.next);
        System.out.println("Xoa thanh cong");
    }

}
