
import binary_search_tree.Tree;
import linked_list.LinkedList;
import product_management.*;
import utilities.Input;

public class Main {

    private static int getChoice() {
        System.out.println("1.  Load Product From File");
        System.out.println("2.  Save Product To File (In order)");
        System.out.println("3.  Insert Product");
        System.out.println("4.  Remove Product by Code");
        System.out.println("5.  Search Product by Code");
        System.out.println("6.  Display (In order)");
        System.out.println("7.  Display (Breadth-first)");
        System.out.println("8.  Balance");
        System.out.println("9.  Product Count");
        System.out.println("10. Load Customer From File");
        System.out.println("11. Save Customer To File");
        System.out.println("12. Add Customer");
        System.out.println("13. Remove Customer by Code");
        System.out.println("14. Search Customer by Code");
        System.out.println("15. Display Customer");
        System.out.println("16. Add Ordering");
        System.out.println("17. Display Ordering");
        System.out.println("18. Sort Ordering");
        System.out.println("0. Exit");

        return Input.getIntegerInclusive("Enter your choice: ", 0, 18);
    }

    private static int getMoreChoice() {
        System.out.println("1. F1");
        System.out.println("2. F2");
        System.out.println("3. F3");
        System.out.println("4. F4");
        System.out.println("5. F5");
        System.out.println("0. Exit");

        return Input.getIntegerInclusive("Enter your choice: ", 0, 5);
    }

    public static void main(String[] args) {
        ProductManagement products = new ProductManagement();
        CustomerManagement customers = new CustomerManagement();
        OrderingManagement orderings = new OrderingManagement();

        while (true) {
            int choice = getMoreChoice();

            switch (choice) {
                case 1: {
                    products.loadDataFromFile(".\\data\\product2.txt");
                    System.out.println("Breadth First");
                    products.displayBreadthFirst();
                    System.out.println("Inorder");
                    products.display();
                    break;
                }
                case 2: {
                    products.getTree().search(new Product("6", "", 0, 0, 0.0)).getData().setQuantity(9);
                    products.displayBreadthFirst();
                    break;
                }
                case 3: {
                    products.getTree().remove(new Product("2", "", 0, 0, 0.0));
                    products.displayBreadthFirst();
                    break;
                }
                case 4: {
                    products.loadDataFromFile(".\\data\\product2.txt");
                    products.getTree().insert(new Product("7", "G", 3, 2, 1.0));
                    products.displayBreadthFirst();
                    break;
                }
                case 5: {
                    products.loadDataFromFile(".\\data\\product2.txt");
                    products.getTree().balance();
                    products.displayBreadthFirst();
                    break;
                }

//                case 1: {
//                    products.loadDataFromFile(".\\data\\product.txt");
//                    break;
//                }
//                case 2: {
//                    products.saveToFileInorder(".\\data\\product-inorder.txt");
//                    break;
//                }
//                case 3: {
//                    products.insertData();
//                    break;
//                }
//                case 4: {
//                    products.deleteByCode();
//                    break;
//                }
//                case 5: {
//                    products.searchByCode();
//                    break;
//                }
//                case 6: {
//                    products.display();
//                    break;
//                }
//                case 7: {
//                    products.displayBreadthFirst();
//                    break;
//                }
//                case 8: {
//                    products.selfBalance();
//                    break;
//                }
//                case 9: {
//                    products.countNumberOfProduct();
//                    break;
//                }
//                case 10: {
//                    customers.loadDataFromFile(".\\data\\customer.txt");
//                    break;
//                }
//                case 11: {
//                    customers.saveToFile(".\\data\\customer.txt");
//                    break;
//                }
//                case 12: {
//                    customers.insertData();
//                    break;
//                }
//                case 13: {
//                    customers.deleteByCode();
//                    break;
//                }
//                case 14: {
//                    customers.searchByCode();
//                    break;
//                }
//                case 15: {
//                    customers.display();
//                    break;
//                }
//                case 16: {
//                    orderings.insertData();
//                    break;
//                }
//                case 17: {
//                    orderings.display();
//                    break;
//                }
//                case 18: {
//                    orderings.sort();
//                    break;
//                }
            }

            if (choice == 0) {
                break;
            }
        }
    }
}
