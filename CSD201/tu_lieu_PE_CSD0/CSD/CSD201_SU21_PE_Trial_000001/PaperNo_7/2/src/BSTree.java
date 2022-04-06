/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

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

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xOwner, int xPrice) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        insert(new Car(xOwner, xPrice));
    }

    public void insert(Car x) {
        Node q = new Node(x);
        if (isEmpty()) {
            root = q;
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            f = p;
            if (x.price < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.price < f.info.price) {
            f.left = q;
        } else {
            f.right = q;
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
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
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.price >= 3 && p.info.price <= 5) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
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
        breadth2(root, f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && r.right != null && r.info.price < 7) {
                deleteByCopy(r);
                return;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    public void deleteByCopy(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == null) {
            return;
        }
        // Find Node f where f is father of p
        Node f = null;
        Node q = root;
        while (q != p) {
            if (q.info.price > p.info.price) {         // Changed
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
//    Node breadth3(Node p) throws Exception {
//        if (p == null) {
//            return null;
//        }
//        Queue q = new Queue();
//        q.enqueue(p);
//        Node r;
//        while (!q.isEmpty()) {
//            r = q.dequeue();
//            if (r.left != null && r.info.price < 7) {
//                return r;
//            }
//            if (r.left != null) {
//                q.enqueue(r.left);
//            }
//            if (r.right != null) {
//                q.enqueue(r.right);
//            }
//        }
//        return null;
//    }
//
//    Node rotateRight(Node p) {
//        if (p == null || p.left == null) {
//            return (p);
//        }
//        Node q = p.left;
//        p.left = q.right;
//        q.right = p;
//        return (q);
//    }
//
//    Node father2(int xPrice) // return the father of the node q, where q.info.price = xPrice
//    {
//        Node f, p;
//        f = null;
//        p = root;
//        while (p != null) {
//            if (p.info.price == xPrice) {
//                break;
//            }
//            f = p;
//            if (xPrice < p.info.price) {
//                p = p.left;
//            } else {
//                p = p.right;
//            }
//        }
//        return (f);
//    }
    void f4() throws Exception {
        clear();
        loadData(10);
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
//        Node q123 = breadth3(root);
//        Node r = rotateRight(q123);
//        Node fa = father2(q123.info.price);
//        if (fa == null) {
//            root = r;
//        } else {
//            if (fa.left == q123) {
//                fa.left = r;
//            } else {
//                fa.right = r;
//            }
//        }
        breadth3(root, f);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void breadth3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (r.left != null && r.right != null && r.info.price < 7) {
                rotateRightWithParent(r);
                break;
            }
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    public void rotateRightWithParent(Node node) {
        Node newNode = rotateRight(node.left, node);
        Node it = root;
        while (it != null) {
            if (it.info.price < node.info.price) {
                if (it.right == node) {
                    it.right = newNode;
                    break;
                }
                it = it.right;
            } else if (it.info.price > node.info.price) {
                if (it.left == node) {
                    it.left = newNode;
                    break;
                }
                it = it.left;
            }
        }
    }

    public void rotateRight() {
        root = rotateRight(root.left, root);
    }

    public Node rotateRight(Node node, Node parent) {
        Node tmp = node.right;
        node.right = parent;
        parent.left = tmp;

        return node;
    }

}
