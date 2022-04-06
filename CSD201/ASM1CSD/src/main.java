
import Product_Management.Customer;
import Product_Management.Product;
import Product_Management.Ordering;
import Validation.Validation;
import java.util.Scanner;
import linked_list.ProductNode;
import linked_list.ProductList;
import linked_list.CustomerList;
import linked_list.OrderingList;

public class main {

    public static void main(String[] args) {
        ProductList plist = new ProductList();
        CustomerList clist = new CustomerList();
        OrderingList olist = new OrderingList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            choice = getMenuChoice();
            switch (choice) {
                case 1:
                    while (true) {
                        int productChoice = getProductChoice();
                        switch (productChoice) {
                            case 1:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                break;
                            case 2:
                                plist.addTail(addProduct());
                                break;
                            case 3:
                                plist.display();
                                break;
                            case 4:
                                plist.saveDataToFile("product1.txt");
                                break;
                            case 5:
                                System.out.println("Enter product code:");
                                plist.searchByCode();
                                break;
                            case 6:
                                System.out.println("Enter product code:");
                                plist.deleteByPcode();
                                break;
                            case 7:
                                plist.sortByProductCode();
                                break;
                            case 8:
                                plist.addAfterPositionK();
                                break;
                            case 9:
                                plist.removeAfterXCode();
                                break;
                            case 11:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.display();
                                break;
                            case 12:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                ProductNode pNode = plist.findProductByCode("2");
                                plist.remove(pNode);
                                plist.display();
                                break;
                            case 13:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.changeQuantityByPcode();
                                plist.display();
                                break;
                            case 14:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.addProductToTheEnd();
                                plist.display();
                                break;
                            case 15:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.sortBySaled();
                                plist.display();
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
                                plist.loadDataFromFile("product.txt");
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
                case 5:
                    OrderingList t = new OrderingList();
                    plist.loadDataFromFile("product.txt");
                    clist.loadDataFromFile("customer.txt");
                    olist.pl = plist;
                    olist.cl = clist;
                    olist.sell("P1", "C1", 1); // Successful
                    olist.sell("P1", "C2", 1); // Not successful because quantity=selled
                    olist.sell("P2", "C2", 2); // Successful
                    plist.display();
                    clist.display();
                    olist.display();
                    System.out.println();
                    break;
            }
        }
    }

    public static int getProductChoice() {
        System.out.println("1. Load data from file \n2. Input & insert data \n3. Inorder traverse \n4. Breadth-first traverse \n5. Inorder traverse to file \n6. Search by pcode \n7. Delete pcode by copying \n8. Simply balancing \n9. Count number product");
        int choice = Validation.getInt("Enter product choice: ", 1, 15);
        return choice;
    }

    public static int getCustomerChoice() {
        System.out.println("1. Load data from file \n2. Input & add to the end \n3. Display data \n4. Save customer list to the file \n5. Search by ccode \n6. Delete by ccode \n7. Back to main menu");
        int choice = Validation.getInt("Enter customer chocie: ", 1, 7);
        return choice;
    }

    public static int getOrderChoice() {
        System.out.println("1. Input data \n2. Display data with total value \n3. Sort by pcode + ccode \n4. Back to main menu");
        int choice = Validation.getInt("Enter order choice: ", 1, 4);
        return choice;
    }

    public static int getMenuChoice() {
        System.out.println("1. Product \n2. Customer \n3. Order \n4. Exit");
        int choice = Validation.getInt("Enter menu choice: ", 1, 5);
        return choice;
    }

    public static Product addProduct() {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();
        System.out.print("Enter product's code: ");
        p.setPcode(sc.nextLine());
        System.out.print("Enter product's name: ");
        p.setPro_name(sc.nextLine());
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
        c.setCus_name(sc.nextLine());
        System.out.print("Enter customer's phone: ");
        c.setPhone(sc.nextLine());
        return c;
    }
}
