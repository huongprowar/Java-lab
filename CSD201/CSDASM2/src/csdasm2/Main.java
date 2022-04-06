package csdasm2;
public class Main {

    public static void main(String[] args) {
      BSTree t = new BSTree();
      int [] a = {7,2,8,1,6,4,3,5};
      t.insertMany(a);
      System.out.println("1. Test breadth-first traversal");
      t.breadth(t.root);
      System.out.println();
      System.out.println("2. Test simple balancing");
      t.balance();
      t.breadth(t.root);
      System.out.println();
    }
    
}
