public class Main {

    public static void main(String[] args) {
      BSTree t = new BSTree();
      String [] a = {"A","B","C","D","E","F","G","H","I"};
      int [] b = {8,3,10,1,6,14,4,7,13};
      t.insertMany(a,b);
      System.out.println("1. Test breadth-first traversal");
      t.breadth(t.root);
      System.out.println();
      System.out.println("2. Test pre-order traversal");
      t.preOrder(t.root);
      System.out.println();
      System.out.println("3. Test in-order traversal");
      t.inOrder(t.root);
      System.out.println();
      System.out.println("4. Test post-order traversal");
      t.postOrder(t.root);
      System.out.println();
    }
    
}
