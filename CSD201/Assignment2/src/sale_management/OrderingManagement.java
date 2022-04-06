package sale_management;

import binary_search_tree.BinarySearchTree;
import binary_search_tree.Node;

/**
 * OrderingManagement
 */
public class OrderingManagement {
    private CustomerList customerList;
    private ProductTree productTree;
    private OrderingList orderingList;

    public OrderingManagement(CustomerList customerList, ProductTree productTree) {
        this.customerList = customerList;
        this.productTree = productTree;
        this.orderingList = new OrderingList();
    }

    public OrderingManagement() {
        this.customerList = new CustomerList();
        this.productTree = new ProductTree();
        this.orderingList = new OrderingList();
    }

    public void loadProduct(String filename) {
        productTree.loadDataFromFile(filename);
    }

    public void loadCustomer(String filename) {
        customerList.loadDataFromFile(filename);
    }

    public void breadthProduct() {
        productTree.display(BinarySearchTree::traversalBreadthFirst);
    }

    public void inOrderProduct() {
        productTree.display(BinarySearchTree::traversalInorder);
    }

    public void book(String productID, String customerID, int quantity) {
        Node<Product> Pnode = productTree.findProductPCode(productID);

        if (Pnode == null) {
            //System.out.println("Not found "+productID+" ID");
            return;
        }
        //System.out.println("found product "+productID+" ID");
        linked_list.Node<Customer> Cnode = customerList.findCustomerByCode(customerID);

        if (Cnode == null) {
            return;
        }

        if (Pnode.getData().getQuantity() - Pnode.getData().getSaled() < quantity) {
            return;
        }

        Pnode.getData().setSaled(Pnode.getData().getSaled() + quantity);
        //System.out.println("Update product "+productID);
        orderingList.addTail(new Ordering(productID, customerID, quantity));
    }

    public void traverse() {
        orderingList.display();
    }
}