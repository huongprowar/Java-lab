
import binary_search_tree.Tree;
import product_management.Customer;
import product_management.Product;
import product_management.Ordering;
import validation.Validation;
import java.util.Scanner;
import linked_list.CustomerList;
import linked_list.OrderingList;
import linked_list.ProductList;
import product_management.CustomerManagement;
import product_management.ProductManagement;
import product_management.OrderingManagement;

public class Main {

    public static void main(String[] args) {
        ProductList plist = new ProductList();
        CustomerList clist = new CustomerList();
        OrderingList olist = new OrderingList();
        ProductManagement ptree = new ProductManagement();
        CustomerManagement ctree = new CustomerManagement();
        OrderingManagement otree = new OrderingManagement();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 10) {
            choice = getMenuChoice();
            switch (choice) {
                case 1:
                    while (true) {
                        int productChoice = getProductChoice();
                        switch (productChoice) {
                            case 1:
                                ptree.loadDataFromFile("product2.txt");
                                break;
                            case 2:
                                ptree.insertData();
                                break;
                            case 3:
                                ptree.display();
                                break;
                            case 4:
                                ptree.displayBreadthFirst();
                            case 5:
                                ptree.loadDataFromFile("product2.txt");
                                break;
                            case 6:
                                System.out.println("Enter product code:");
                                ptree.searchByCode();
                                break;
                            case 7:
                                System.out.println("Enter product code:");
                                ptree.deleteByCode();
                                break;
                            case 8:
                                ptree.selfBalance();
                                break;
                            case 9:
                                ptree.countNumberOfProduct();
                                break;
                        }
                        if (productChoice == 10) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        int customerChoice = getCustomerChoice();
                        switch (customerChoice) {
                            case 1:
                                clist.clear();
                                clist.loadDataFromFile("customer.txt");
                                break;
                            case 2:
                                clist.addTail(addCustomer());
                                break;
                            case 3:
                                clist.display();
                                break;
                            case 4:
                                clist.saveDataToFile("customer.txt");
                                break;
                            case 5:
                                System.out.println("Enter product code:");
                                clist.searchByCCode();
                                break;
                            case 6:
                                System.out.println("Enter product code:");
                                clist.deleteByCCode();
                                break;
                        }
                        if (customerChoice == 7) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        int orderChoice = getOrderChoice();
                        switch (orderChoice) {
                            case 1:
                                plist.loadDataFromFile("product2.txt");
                                clist.loadDataFromFile("customer.txt");
                                olist.pl = plist;
                                olist.cl = clist;
                                olist.addOrdering();
                                break;
                            case 2:
                                olist.display();
                                break;
                            case 3:
                                olist.sortByPcode();
                                break;
                        }
                        if (orderChoice == 4) {
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("1A");
                    ptree.loadDataFromFile("product2.txt");
                    ptree.displayBreadthFirst();
                    break;
                case 5:
                    System.out.println("1B");
                    ptree.loadDataFromFile("product2.txt");
                    ptree.display();
                    break;
                case 6:
                    System.out.println("2");
                    ptree.loadDataFromFile("product2.txt");
                    ptree.getTree().search(new Product("6", "", 0, 0, 0.0)).getData().setQuantity(9);
                    ptree.displayBreadthFirst();
                    break;

                case 7:
                    System.out.println("3");
                    ptree.loadDataFromFile("product2.txt");
                    ptree.getTree().remove(new Product("2", "", 0, 0, 0.0));
                    ptree.displayBreadthFirst();
                    break;
                case 8:
                    System.out.println("4");
                    ptree.loadDataFromFile("product2.txt");
                    ptree.getTree().insert(new Product("7", "G", 3, 2, 1.0));
                    ptree.displayBreadthFirst();
                    break;
                case 9:
                    System.out.println("5");
                    ptree.loadDataFromFile("product2.txt");
                    ptree.displayBreadthFirst();
                    break;
                case 10:
                    ptree.loadDataFromFile("product.txt");
                    clist.loadDataFromFile("customer.txt");
                    ptree.displayBreadthFirst(); // (1)
                    ptree.display(); // (2)
                    olist.book("P9", "C1", 1); // not ok
                    olist.book("P4", "C1", 1); // ok
                    olist.book("P4", "C2", 1); // not ok
                    plist.; // (3)
                    plist.display(); // (4) 

            }
        }
    }

    public static int getProductChoice() {
        System.out.println("1. Load data from file \n2. Input & insert data \n3. Inorder traverse \n4. Breadth-first traverse \n5. Inorder traverse to file \n6. Search by pcode \n7. Delete pcode by copying \n8. Simply balancing \n9. Count number product");
        int choice = Validation.getInteger("Enter product choice: ", 1, 15);
        return choice;
    }

    public static int getCustomerChoice() {
        System.out.println("1. Load data from file \n2. Input & add to the end \n3. Display data \n4. Save customer list to the file \n5. Search by ccode \n6. Delete by ccode \n7. Back to main menu");
        int choice = Validation.getInteger("Enter customer chocie: ", 1, 7);
        return choice;
    }

    public static int getOrderChoice() {
        System.out.println("1. Input data \n2. Display data with total value \n3. Sort by pcode + ccode \n4. Back to main menu");
        int choice = Validation.getInteger("Enter order choice: ", 1, 4);
        return choice;
    }

    public static int getMenuChoice() {
        System.out.println("1. Product \n2. Customer \n3. Order \n4. Exit");
        int choice = Validation.getInteger("Enter menu choice: ", 1, 10);
        return choice;
    }

    public static Product addProduct() {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();
        System.out.print("Enter product's code: ");
        p.setPcode(sc.nextLine());
        System.out.print("Enter product's name: ");
        p.setPname(sc.nextLine());
        System.out.print("Enter product's quantity: ");
        p.setQuantity(sc.nextInt());
        System.out.print("Enter product's saled: ");
        p.setSaled(sc.nextInt());
        System.out.print("Enter product's price: ");
        p.setPrice(sc.nextDouble());
        return p;
    }

    public static Customer addCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        System.out.print("Enter customer's code: ");
        c.setCcode(sc.nextLine());
        System.out.print("Enter customer's name: ");
        c.setCname(sc.nextLine());
        System.out.print("Enter customer's phone: ");
        c.setPhone(sc.nextLine());
        return c;
    }
}
