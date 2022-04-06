
package product_management;

import binary_search_tree.Tree;
import utilities.Input;

public class OrderingManagement {

    Tree<Ordering> tree;

    public OrderingManagement() {
        tree = new Tree<>();
    }

    public void insertData() {
        Ordering p = new Ordering();

        p.setPcode(Input.getString("Enter product code: "));
        p.setCcode(Input.getString("Enter customer code: "));
        p.setQuantity(Input.getIntegerInclusive("Enter quantity: ", 0, Integer.MAX_VALUE));

        tree.insert(p);
    }

    public void display() {
        tree.inorderTraversal((node) -> {
            System.out.println(node.getData());
        });
    }
}
