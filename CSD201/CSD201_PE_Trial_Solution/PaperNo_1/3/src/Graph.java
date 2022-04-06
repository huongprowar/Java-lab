/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) //do not edit this function
    {
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]);
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
    }

    void dijkstra(int fro, int to, RandomAccessFile f) throws IOException {
        boolean[] S = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int INF = 999;
        int i, j, k, t;
        for (i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        S[fro] = true;
        while (true) {
            // find d[k] = min {d[i}}
            t = INF;
            k = -1;
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] < t) {
                    t = d[i];
                    k = i;
                }
            }
            if (k == -1) {
                return;
            }
            // add k to S
            S[k] = true;
            if (k == to) {
                break;
            }
            // update d[i] & p[i]
            for (i = 0; i < n; i++) {
                if (S[i] == true) {
                    continue;
                }
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
//    System.out.println("The shortest distance is " + d[to]);
        i = to;
        Stack s = new Stack();//store vertex
        ArrayList points = new ArrayList();//store distance
        while (true) {
            s.push(i);
            if (i == fro) {
                break;
            }
            i = p[i];
        }
//print line 1: vertex, line2 : distance

        while (!s.isEmpty()) {
            i = s.pop();
            points.add(i);
        }
        for (int l = 0; l < points.size(); l++) {
            f.writeBytes(v[(int)points.get(l)] + " ");//print vertex
        }
        f.writeBytes("\n");
        for (int l = 0; l < points.size(); l++) {
            f.writeBytes(d[(int) points.get(l)] + " ");//print distance
        }
        f.writeBytes("\n");

//print (0)A->(9)C->(2)F->(9)E
//        for (int l = 0; l < points.size() - 1; l++) {
//            f.writeBytes("(" + d[(int) points.get(l)] + ")" + v[l] + " " + "->");
//        }
   //     f.writeBytes("(" + d[(int) points.get(points.size() - 1)] + ")" + v[points.size() - 1] + " ");
        f.writeBytes("\n");
    }

    boolean hasEulerCycle() {
        if (!hasIsolated() && isUnDirected() && isConnected() && allDegEven()) {
            return (true);
        } else {
            return (false);
        }
    }

    boolean allDegEven() {
        for (int i = 0; i < n; i++) {
            if (deg(i) % 2 == 1) {
                return (false);
            }
        }
        return (true);
    }

    boolean hasIsolated() {
        for (int i = 0; i < n; i++) {
            if (deg(i) == 0) {
                return (true);
            }
        }
        return (false);
    }

    void eulerCycle(int fro, RandomAccessFile f) throws IOException {
        if (!hasEulerCycle()) {
            return;
        }
        int[] eu = new int[100];
        int m, i, j, r;
        Stack s = new Stack();
        s.push(fro);
        j = 0;
        while (!s.isEmpty()) {
            r = s.top();
            for (i = 0; i < n; i++) {
                if (a[r][i] > 0) {
                    break;
                }
            }
            if (i == n) { //r is isolated
                s.pop();
                eu[j++] = r;

            } else {
                s.push(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        m = j;
        for (i = 0; i < m; i++) {
            f.writeBytes(v[eu[i]] + " ");
        }
    }

    /*
declare a stack S of characters (a vertex is labeled by a character)
declare an empty array E (which will contain Euler cycle)
push the vertex X to S
while(S is not empty)
 {ch = top element of the stack S 
  if ch is isolated then remove it from the stack and put it to E
   else
   select the first vertex Y (by alphabet order), which is adjacent
   to ch,push  Y  to S and remove the edge (ch,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
     */
    void EulerCycle(int k, RandomAccessFile f) throws Exception {
        if (!isUnDirected() || !isConnected() || !isEvenDegree()) {
            f.writeBytes("Conditions are not satisfied\r\n");
            return;
        }
        Stack s = new Stack();
        int[][] b = new int[20][20];
        int[] eu = new int[20];
        int m;
        int i, j, r;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                b[i][j] = a[i][j];
            }
        }
        s.push(k);//Dua dinh k vao Stack
        m = 0;//Ban dau chu trinh chua co phan tu nao
        while (!s.isEmpty()) {
            r = s.top();
            i = 0;
            while (i < n && b[r][i] == 0) {
                i++;//Tim i dau tien de b[r][i]#0
            }
            if (i == n) //r da la dinh co lap, dua  r  vao chu trinh Euler
            {
                eu[m++] = r;
                s.pop();
            }//Lay dinh co lap ra khoi Stack
            else {
                s.push(i);
                b[r][i]--;
                b[i][r]--;
            }//Loai canh (i,r) khoi do thi
        }
        // Display Euler cycle
        for (i = 0; i < m; i++) {
            f.writeBytes(v[eu[i]] + "  ");
        }
        f.writeBytes("\r\n");
    }

//check conditions for the existence of Euler’s cycle
    void checkEulerCycle(RandomAccessFile f) throws Exception {
        if (isUnDirected()) {
            f.writeBytes("The graph is undirected.\r\n");
        } else {
            f.writeBytes("The graph is directed.\r\n");
        }
        if (isConnected()) {
            f.writeBytes("The graph is connected.\r\n");
        } else {
            f.writeBytes("The graph is not connected.\r\n");
        }

        if (isEvenDegree()) {
            f.writeBytes("All vertices have even degree.\r\n");
        } else {
            f.writeBytes("The graph has a vertex with odd degree.\r\n");
        }
        if (isUnDirected() && isConnected() && isEvenDegree()) {
            f.writeBytes("Conditions for Euler's cycle are satisfied.\r\n");
        } else {
            f.writeBytes("Conditions for Euler's cycle are not satisfied.\r\n");
        }
    }

    boolean isEvenDegree() {
        int i, j, deg;
        for (i = 0; i < n; i++) {
            deg = 0;
            for (j = 0; j < n; j++) {
                deg += a[i][j];
            }
            if (deg % 2 == 1) {
                return (false);
            }
        }
        return (true);
    }

    boolean isUnDirected() {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (a[i][j] != a[j][i]) {
                    return (false);
                }
            }
        }
        return (true);
    }

    boolean isConnected() {
        boolean[] p = new boolean[n];
        int i, j, r;
        for (i = 0; i < n; i++) {
            p[i] = false;
        }
        Stack s = new Stack();
        s.push(0);
        p[0] = true;
        while (!s.isEmpty()) {
            r = s.pop();
            for (i = 0; i < n; i++) {
                if (!p[i] && a[r][i] > 0) {
                    s.push(i);
                    p[i] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (!p[i]) {
                return (false);
            }
        }
        return (true);
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth1(1, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void depth1(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[k] + "(" + deg(k) + ")");
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth1(visited, i, f);
            }
        }
    }

    void depth1(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth1(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth1(visited, i, f);
            }
        }
    }
//===========================================================================

    void f2() throws Exception {
        loadData(12);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        dijkstra(0, 4, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//===========================================================================
/*
Algorithm for finding an Euler cycle from the vertex X using stack 
//Input: Connected graph G with all vertices having even degrees
//Output: Euler cycle
declare a stack S of characters
declare empty array E (which will contain Euler cycle)
push the vertex X to S
while(S is not empty)
 {r = top element of the stack S 
  if r is isolated then remove it from the stack and put it to E
   else
   select the first vertex Y (by alphabet order), which is adjacent
   to r, push  Y  to  S and remove the edge (r,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
     */
    void f3() throws Exception {
        loadData(20);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt  
        EulerCycle(1, f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

}
//=================================================================
