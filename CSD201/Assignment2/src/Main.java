
import javax.swing.SpinnerDateModel;

import sale_management.CustomerList;
import sale_management.OrderingList;
import sale_management.OrderingManagement;
import sale_management.Product;
import sale_management.ProductTree;
import utilities.Input;

public class Main {

    private static int getChoice() {
        System.out.println("\n\n\n------------------------------------------------------------------------");
        System.out.println("1. Insert Product");
        System.out.println("2. Remove Product By Code");
        System.out.println("3. Search Product By Code");
        System.out.println("4. Print Product Tree (In Order)");
        System.out.println("5. Print Product Tree (Breadth First)");
        System.out.println("6. Load Product Tree From File");
        System.out.println("7. Save Product Tree To File (In Order)");
        System.out.println("8. Balance Product Tree");
        System.out.println("9. Number of Products");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("10. Add Customer");
        System.out.println("11. Remove Customer By Code");
        System.out.println("12. Search Customer By Code");
        System.out.println("13. Print Customer");
        System.out.println("14. Load Customer From File");
        System.out.println("15. Save Customer To File");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("16. Add Ordering");
        System.out.println("17. Print Ordering");
        System.out.println("18. Sort Ordering");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("19. f1");
        System.out.println("20. f2");
        System.out.println("21. f3");
        System.out.println("22. f4");
        System.out.println("23. f5");
        System.out.println("0. Exit");

        return Input.getIntegerInclusive("Enter your choice: ", 0, 23);
    }

    public static void main(String[] args) {
        OrderingManagement t = new OrderingManagement();

        t.loadProduct("product.txt");
        t.loadCustomer("customer.txt");
        System.out.println("(1)");
        t.breadthProduct(); // (1)
        System.out.println("\n(2)");
        t.inOrderProduct(); // (2)
        t.book("P9", "C1", 1); // not ok
        t.book("P4", "C1", 1); // ok
        t.book("P4", "C2", 1); // not ok
        System.out.println("\n(3)");
        t.breadthProduct(); // (3)
        
        System.out.println("\n(4)");
        t.traverse(); // (4)

        // while (true) {
        // int choice = getChoice();
        // switch (choice) {
//                        case 1:
//                    while (true) {
//                        int productChoice = getProductChoice();
//                        switch (productChoice) {
//                            case 1:
//                                ptree.loadDataFromFile("product2.txt");
//                                break;
//                            case 2:
//                                ptree.insertData();
//                                break;
//                            case 3:
//                                ptree.display();
//                                break;
//                            case 4:
//                                ptree.displayBreadthFirst();
//                            case 5:
//                                ptree.loadDataFromFile("product2.txt");
//                                break;
//                            case 6:
//                                System.out.println("Enter product code:");
//                                ptree.searchByCode();
//                                break;
//                            case 7:
//                                System.out.println("Enter product code:");
//                                ptree.deleteByCode();
//                                break;
//                            case 8:
//                                ptree.selfBalance();
//                                break;
//                            case 9:
//                                ptree.countNumberOfProduct();
//                                break;
//                        }
//                        if (productChoice == 10) {
//                            break;
//                        }
//                    }
//                    break;
//                case 2:
//                    while (true) {
//                        int customerChoice = getCustomerChoice();
//                        switch (customerChoice) {
//                            case 1:
//                                clist.clear();
//                                clist.loadDataFromFile("customer.txt");
//                                break;
//                            case 2:
//                                clist.addTail(addCustomer());
//                                break;
//                            case 3:
//                                clist.display();
//                                break;
//                            case 4:
//                                clist.saveDataToFile("customer.txt");
//                                break;
//                            case 5:
//                                System.out.println("Enter product code:");
//                                clist.searchByCCode();
//                                break;
//                            case 6:
//                                System.out.println("Enter product code:");
//                                clist.deleteByCCode();
//                                break;
//                        }
//                        if (customerChoice == 7) {
//                            break;
//                        }
//                    }
//                    break;
//                case 3:
//                    while (true) {
//                        int orderChoice = getOrderChoice();
//                        switch (orderChoice) {
//                            case 1:
//                                plist.loadDataFromFile("product2.txt");
//                                clist.loadDataFromFile("customer.txt");
//                                olist.pl = plist;
//                                olist.cl = clist;
//                                olist.addOrdering();
//                                break;
//                            case 2:
//                                olist.display();
//                                break;
//                            case 3:
//                                olist.sortByPcode();
//                                break;
//                        }
//                        if (orderChoice == 4) {
//                            break;
//                        }
//                    }
//                    break;
//                case 4:
//                    System.out.println("1A");
//                    ptree.loadDataFromFile("product2.txt");
//                    ptree.displayBreadthFirst();
//                    break;
//                case 5:
//                    System.out.println("1B");
//                    ptree.loadDataFromFile("product2.txt");
//                    ptree.display();
//                    break;
//                case 6:
//                    System.out.println("2");
//                    ptree.loadDataFromFile("product2.txt");
//                    ptree.getTree().search(new Product("6", "", 0, 0, 0.0)).getData().setQuantity(9);
//                    ptree.displayBreadthFirst();
//                    break;
//
//                case 7:
//                    System.out.println("3");
//                    ptree.loadDataFromFile("product2.txt");
//                    ptree.getTree().remove(new Product("2", "", 0, 0, 0.0));
//                    ptree.displayBreadthFirst();
//                    break;
//                case 8:
//                    System.out.println("4");
//                    ptree.loadDataFromFile("product2.txt");
//                    ptree.getTree().insert(new Product("7", "G", 3, 2, 1.0));
//                    ptree.displayBreadthFirst();
//                    break;
//                case 9:
//                    System.out.println("5");
//                    ptree.loadDataFromFile("product2.txt");
//                    ptree.displayBreadthFirst();
//                    break;
//                case 10:
//                    ptree.loadDataFromFile("product.txt");
//                    clist.loadDataFromFile("customer.txt");
//                    ptree.displayBreadthFirst(); // (1)
//                    ptree.display(); // (2)
//                    olist.book("P9", "C1", 1); // not ok
//                    olist.book("P4", "C1", 1); // ok
//                    olist.book("P4", "C2", 1); // not ok
//                    plist.; // (3)
//                    plist.display(); // (4) 
//
//            }
//        }
    }
}
