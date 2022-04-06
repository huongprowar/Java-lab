public class Main {

    public static void main(String[] args) {
      BSTree t = new BSTree();
      int [] a = {9,6,10,2,7,1,3,8,5,4};
      t.insertMany(a);
      System.out.println("1. Test breadth-first traversal");
      t.breadth(t.root);
      System.out.println();
      System.out.println("2. Test deletion by copy");
      t.deleByCopy(6);
      t.breadth(t.root);
      System.out.println();
    }
    
}
