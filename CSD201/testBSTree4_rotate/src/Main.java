public class Main {

    public static void main(String[] args) {
      BSTree t = new BSTree();
      int [] a = {7,5,8,1,6,3,2,4};
      t.insertMany(a);
      System.out.println("1. Test breadth-first traversal");
      t.breadth(t.root);
      System.out.println();
      System.out.println("2. Test rotation to right");
      t.root = t.rotateRight(t.root);
      t.breadth(t.root);
      System.out.println();
    }
    
}
