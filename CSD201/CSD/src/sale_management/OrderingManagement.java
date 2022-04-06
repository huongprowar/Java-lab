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
        Node<Product> nodeProduct = productTree.findProductByCode(productID);

        if (nodeProduct == null) {
            return;
        }

        linked_list.Node<Customer> nodeCustomer = customerList.findCustomerByCode(customerID);

        if (nodeCustomer == null) {
            return;
        }

        if (nodeProduct.getData().getQuantity() - nodeProduct.getData().getSaled() < quantity) {
            return;
        }

        nodeProduct.getData().setSaled(nodeProduct.getData().getSaled() + quantity);

        orderingList.addTail(new Ordering(productID, customerID, quantity));
    }

    public void traverse() {
        orderingList.display();
    }
}