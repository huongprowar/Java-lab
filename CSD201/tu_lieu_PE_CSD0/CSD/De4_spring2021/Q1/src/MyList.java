/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xOwner, int xPrice, int xColor) {
        //You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'B') {
            return;
        }
        Bat bat = new Bat(xOwner, xPrice, xColor);
        Node node = new Node(bat);
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bat x, y;
        x = new Bat("X", 1, 2);
        y = new Bat("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addFirst(y);
        addFirst(x);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void addFirst(Bat bat) {
        Node node = new Node(bat);
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        node.next = head;
        head = node;
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        dele(head);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void dele(Node q) {
        Node cur, pre;
        cur = head;
        pre = null;
        while (cur != null) {
            if (cur.info.price < 6) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        if (pre == null) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        pre.next = cur.next;
        if (pre.next == null) {
            tail = pre;
        }
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sort();
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    public void sort() {
        Node pi, pj;
        pi = head;
        int count = 0;
        while (pi != null) {
            count++;
            pj = pi.next;
            int count1 = 0;
            while (pj != null) {
                count1++;
                if (pi.info.price > pj.info.price) {
                    Bat t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
                pj = pj.next;
                if (count1 == 4 - count) {
                    break;
                }
            }
            pi = pi.next;
            if (count == 3) {
                break;
            }
        }
    }
}
