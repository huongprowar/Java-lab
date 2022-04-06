/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(Corn x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.type == x.type) {
                return;
            }
            f = p;
            if (x.type < p.info.type) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.type < f.info.type) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    void insert(String xCode, int xType, int xPrice) {
        //You should insert here statements to complete this function
        if (xCode.charAt(0) == 'B') {
            return;
        }
        insert(new Corn(xCode, xType, xPrice));
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(2);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.info.price < 5) {
            fvisit(p, f);
        }
        inOrder2(p.right, f);
    }

    void f2() throws Exception {
        clear();
        loadData(6);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        inOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================  
    void f3() throws Exception {
        clear();
        loadData(10);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
        preOrder2(root);
        //------------------------------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.type < 10) {
            deleteByCopy(p);
            return;
        }
        preOrder2(p.left);
        preOrder2(p.right);
    }

    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            System.out.println("Key does not exists, deletion failed");
            return;
        }
        // Find Node f where f is father of p
        Node f = null;
        Node q = root;
        while (q != p) {
            if (q.info.type > p.info.type) {         // Changed
                f = q;
                q = q.left;
            } else {
                f = q;
                q = q.right;
            }
        }
        // 1. p is a leaf (no right and left child)
        if (p.left == null && p.right == null) {
            // a BST has a Node only
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else if (f.right == p) {
                f.right = null;
            }
        } // 2. p has a left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {// remove root
                root = p.left;
            } else if (f.right == p) {
                f.right = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            }
        } // 3. p has a right child only
        else if (p.right != null && p.left == null) {
            if (f == null) {// remove root
                root = p.right;
            } else if (f.right == p) {
                f.right = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            }
        } // 4. Both of right and left child 
        else if (p.left != null && p.right != null) {
            f = null;
            Node rp = p.left;
            while (rp.right != null) {
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if (f == null) {// rp has no right child 
                p.left = rp.left;
            } else {
                f.right = rp.left;
            }
        }
    }

//=============================================================
//    Node search(Node p, int x) {
//        if (p == null) {
//            return (null);
//        }
//        if (p.info.type == x) {
//            return (p);
//        }
//        if (x < p.info.type) {
//            return (search(p.left, x));
//        } else {
//            return (search(p.right, x));
//        }
//    }
//
//    int count(Node p, RandomAccessFile f) throws Exception {
//        Queue q = new Queue();
//        q.enqueue(p);
//        Node r;
//        int count = 0;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            count++;
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//        }
//        return count;
//    }
    void f4() throws Exception {
        clear();
        loadData(14);;
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
//        Node p = search(root, 5);
//        int k = count(p, f);
//        Queue q = new Queue();
//        q.enqueue(p);
//        Node r;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            if (r == p) {
//                r.info.price = k;
//            }
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//}
        Node p = search(root, 5);
        p.info.price = count(p);
        
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info.type == key) {
            return p;
        } else if (p.info.type > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

    public int count(Node p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = count(p.left);
        h = count(p.right);
        r = k + h + 1;
        return (r);
    }

}
