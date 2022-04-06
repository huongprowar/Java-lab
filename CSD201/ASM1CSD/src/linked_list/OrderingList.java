package linked_list;

import Product_Management.Ordering;
import Product_Management.Product;
import Product_Management.Customer;
import java.util.Scanner;

public class OrderingList {

    private OrderingNode head, tail;

    public OrderingList() {
    }

    public CustomerList cl = new CustomerList();
    public ProductList pl = new ProductList();
    public Product p = new Product();
    public ProductNode pn = new ProductNode();

    public void clear() {
        head = tail = null;
    }

    public void display() {
        OrderingNode it = head;
        System.out.printf("%6s | %15s | %10s\n", "pcode", "ccode", "quantity");
        while (it != null) {
            System.out.printf("%6s | %15s | %10s\n",
                    it.data.getPcode(),
                    it.data.getCcode(),
                    it.data.getQuantity());
            it = it.next;

        }
    }

    public void add(Ordering data) {
        OrderingNode node = new OrderingNode();
        node.data = data;

        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void addTail(Ordering data) {
        OrderingNode node = new OrderingNode();
        node.data = data;
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public OrderingNode findPCodeInOrderList(String pcode) {
        if (head == null && tail == null) {
            return null;
        }
        OrderingNode it = head;
        while (it != null) {
            if (it.data.getPcode().equals(pcode)) {
                return it;
            }
            it = it.next;
        }
        return null;
    }

    public OrderingNode findCCodeInOrderList(String ccode) {
        if (head == null && tail == null) {
            return null;
        }
        OrderingNode it = head;
        while (it != null) {
            if (it.data.getCcode().equals(ccode)) {
                return it;
            }
            it = it.next;
        }
        return null;
    }

    public void addOrdering() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product code: ");
        String pcode = sc.nextLine();

        System.out.print("Enter customer code: ");
        String ccode = sc.nextLine();

        System.out.print("Nhap quantity: ");
        int quantity = sc.nextInt();

        if (cl.findCustomerByCode(ccode) == null && pl.findProductByCode(pcode) == null) {
            System.out.println("Data khong duoc chap nhan 1");
            return;
        }

        if (findCCodeInOrderList(ccode) != null && findPCodeInOrderList(pcode) != null) {
            System.out.println("Data khong duoc chap nhan 2");
            return;
        }

        if (p.getSaled() == quantity) {
            System.out.println("Het hang");
        }
        System.out.println("Nhap k: ");
        int k = sc.nextInt();
        if (k > quantity - p.getSaled()) {
            return;
        }
        addTail(new Ordering(pcode, ccode, quantity));
        System.out.println("Them thanh cong!");
    }

    public void sell(String pcode, String ccode, int quantity) {

        if (cl.findCustomerByCode(ccode) == null || pl.findProductByCode(pcode) == null) {
            System.out.println("Data khong duoc chap nhan 1");
            return;
        }

        if (findCCodeInOrderList(ccode) != null && findPCodeInOrderList(pcode) != null) {
            System.out.println("Data khong duoc chap nhan 2");
            return;
        }
        // bug, t muốn lấy Saled của product được chỉ đến
        if (pl.findProductByCode(pcode).data.getSaled() == quantity) {
            System.out.println("Het hang");
            return;
        }
        
        addTail(new Ordering(pcode, ccode, quantity));
        System.out.println("Them thanh cong!");
    }

    private int compare(OrderingNode a1, OrderingNode a2) {
        if (a1.data.getPcode() == a2.data.getPcode()) {
            return a1.data.getPcode().compareTo(a2.data.getPcode());
        }
        return a1.data.getCcode().compareTo(a2.data.getCcode());
    }

    public void sortByPcode() {
        while (true) {
            boolean check = true;
            OrderingNode tmp = head;
            while (tmp.next != null) {
                if (compare(tmp, tmp.next) > 0) {
                    Ordering tmpnode = tmp.data;
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

}
