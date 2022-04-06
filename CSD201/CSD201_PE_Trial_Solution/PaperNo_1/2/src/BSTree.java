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
        insert2(new Car(xOwner, xPrice));
    }

    public void insert2(Car car) {
        Node node = new Node(car);

        Node it = root;
        while (it != null) {
            if (it.info.price < car.price) {
                if (it.right == null) {
                    it.right = node;
                    return;
                }
                it = it.right;
            } else {
                if (it.left == null) {
                    it.left = node;
                    return;
                }
                it = it.left;
            }
        }

        root = node;
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
        breadth2(root);
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void breadth2(Node p) {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
//        int count = 0;
        
        while (!q.isEmpty()) {
            r = q.dequeue();
            // fvisit()
            if (r.info.price < 7 && r.left != null && r.right != null) {
                // xoa
                remove(r.info);
                break;
//                count++;
//                if (count >= 2) {
//                    break;
//                }
            }

            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    public void remove(Car car) {
        root = nodeAfterRemove(root, car);
    }

    // remove by copy
    private Node nodeAfterRemove(Node node, Car car) {
        if (node == null) {
            return null;
        }

        if (node.info.price < car.price) {
            node.right = nodeAfterRemove(node.right, car);
        } else if (node.info.price > car.price) {
            node.left = nodeAfterRemove(node.left, car);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Node maxNode = node.left;
            while (maxNode.right != null) {
                maxNode = maxNode.right;
            }

            node.info = maxNode.info;
            node.left = nodeAfterRemove(node.left, maxNode.info);
        }

        return node;
    }

//=============================================================
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

        breadth3(root);

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void breadth3(Node p) {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r = null, pre;
        while (!q.isEmpty()) {
            pre = r;
            r = q.dequeue();
            // fvisit()
            if (r.info.price < 7 && r.left != null) {
                // right rotate
                if (pre != null) {
                    if (pre.left == r) {
                        pre.left = rotateRight(r.left, r);
                    } else {
                        pre.right = rotateRight(r.left, r);
                    }
                }
                else {
                    root = rotateRight(root.left, root);
                }
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

    public Node rotateRight(Node node, Node parent) {
        Node tmp = node.right;
        node.right = parent;
        parent.left = tmp;

        return node;
    }
}
