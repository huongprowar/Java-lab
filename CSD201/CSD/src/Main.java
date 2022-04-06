
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

        t.loadProduct(".\\data\\product.txt");
        t.loadCustomer(".\\data\\customer.txt");
        System.out.println();
        t.breadthProduct(); // (1)
        System.out.println();
        t.inOrderProduct(); // (2)
        t.book("P9", "C1", 1); // not ok
        t.book("P4", "C1", 1); // ok
        t.book("P4", "C2", 1); // not ok
        System.out.println();
        t.breadthProduct(); // (3)
        
        System.out.println();
        t.traverse(); // (4)

        // while (true) {
        // int choice = getChoice();
        // switch (choice) {
        // case 1:
        // products.addProduct();
        // break;
        // case 2:
        // products.deleteByCode();
        // break;
        // case 3:
        // products.searchByCode();
        // break;
        // case 4:
        // products.display(ProductTree::traversalInorder);
        // break;
        // case 5:
        // products.display(ProductTree::traversalBreadthFirst);
        // break;
        // case 6:
        // products.loadDataFromFile(".\\data\\product2.txt");
        // break;
        // case 7:
        // products.saveDataToFile(".\\data\\product-.txt",
        // ProductTree::traversalInorder);
        // break;
        // case 8:
        // products.balance();
        // break;
        // case 9:
        // products.countNumberOfProducts();
        // break;
        // case 10:
        // customers.addCustomer();
        // break;
        // case 11:
        // customers.removeByCode(orderings);
        // break;
        // case 12:
        // customers.searchByCode();
        // break;
        // case 13:
        // customers.display();
        // break;
        // case 14:
        // customers.loadDataFromFile(".\\data\\customer.txt");
        // break;
        // case 15:
        // customers.saveDataToFile(".\\data\\customer-.txt");
        // break;
        // case 16:
        // orderings.addOrdering(products, customers);
        // break;
        // case 17:
        // orderings.display();
        // break;
        // case 18:
        // orderings.sort();
        // break;

        // case 19:
        // products.loadDataFromFile(".\\data\\product2.txt");
        // System.out.println("breadth first traversal: ");
        // products.display(ProductTree::traversalBreadthFirst);
        // System.out.println("in order traversal: ");
        // products.display(ProductTree::traversalInorder);
        // break;
        // case 20:
        // products.search(new Product("6", "", 0, 0, 0.0)).getData().setQuantity(9);
        // products.display(ProductTree::traversalBreadthFirst);
        // break;
        // case 21:
        // products.remove(new Product("2", "", 0, 0, 0.0));
        // products.display(ProductTree::traversalBreadthFirst);
        // break;
        // case 22:
        // products.loadDataFromFile(".\\data\\product2.txt");
        // products.insert(new Product("7", "G", 3, 2, 1.0));
        // products.display(ProductTree::traversalBreadthFirst);
        // break;
        // case 23:
        // products.loadDataFromFile(".\\data\\product2.txt");
        // products.balance(products.search(new Product("3", "", 0, 0, 0.0)));
        // products.display(ProductTree::traversalBreadthFirst);
        // break;
        // }

        // if (choice == 0) {
        // break;
        // }
        // }
    }
}
