
import java.text.NumberFormat;
import java.io.*;
import java.util.*;

public class BSTree {

    ArrayList<Book> t;
    Validate v = new Validate();

    Node root;

    BSTree() {
        t = new ArrayList<Book>();
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void fvisitBal(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.bcode + " | " + p.info.tittle + " | " + p.info.quantity + " | " + p.info.lended + " | " + p.info.price + ") ");
        }
    }

    void fvisitLevel(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes("(" + p.info.bcode + " | " + p.info.tittle + " | " + p.info.quantity + " | " + p.info.lended + " | " + p.info.price + ") ");
        }
    }
   

    void display() {
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t.get(i));
        }
        System.out.println();
    }

    void add(Book x) {
        t.add(x);
    }

    void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s;
        String[] a;
        String xBcode;
        String xTitle;
        int xQuantity;
        int xLended;
        double xPrice;
        Book x;
        while (true) {
            s = f.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            a = s.split("[|]");
            xBcode = a[0].trim();
            xTitle = a[1].trim();
            xQuantity = Integer.parseInt(a[2].trim());
            xLended = Integer.parseInt(a[3].trim());
            xPrice = Double.parseDouble(a[4].trim());
            x = new Book(xBcode, xTitle, xQuantity, xLended, xPrice);
            add(x);
        }
        f.close();
    }

    void saveFile(String fname) throws IOException {
        if (isEmpty()) {
            return;
        }
        File f = new File(fname);
        if (f.exists()) {
            f.delete();
        }
        RandomAccessFile g = new RandomAccessFile(fname, "rw");
        int n, i;
        Book x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            g.writeBytes(x.bcode + " | " + x.tittle + " | " + x.quantity + " | " + x.lended + " | " + "\r\n");
        }
        g.close();
    }

    Node search(Node root, String bcode) {
        if (root == null) {
            return (null);
        }
        if (root.info.bcode.equals(bcode)) {
            return (root);
        }
        if (root.info.bcode.compareToIgnoreCase(bcode) > 0)//left
        {
            return (search(root.left, bcode));
        } else {
            return (search(root.right, bcode));
        }
    }
   

    Node insert(Node root, Book x) {
        if (root == null) {
            root = new Node(x);
            return (root);
        }
        if (root.info == x) {
            System.out.println("The book " + x.bcode + " already exists. No insertion");
            return (root);
        }
        if (Integer.parseInt(root.info.bcode) > Integer.parseInt(x.bcode)) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        return (root);

    }

    public void insert() {
        String bcode = v.checkString("Enter bcode: ");
        String tittle = v.checkString("Enter tittle: ");
        int quantity = v.checkInt("Enter quantity: ");
        int lended = v.checkInt("Enter lended: ");
        double price = v.checkDouble("Enter price: ");
        Book b = new Book(bcode, tittle, quantity, lended, price);
        insert(b);
    }

    void insert(Book x) {
        root = insert(root, x);
    }

    void insertMany(ArrayList<Book> t) {
        for (Book a1 : t) {
            insert(a1);
        }
    }

    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info.toString());
        }
    }

    int count(Node p) {
        ArrayList<Book> t = new ArrayList<>();
        int c = 0;
        if (p == null) {
            return 0;
        }
        inOrder(p.left);
        t.add(p.info);
        inOrder(p.right);
        c = t.stream().map((_item) -> 1).reduce(c, Integer::sum);
        return c;
    }

    void breadth(Node root) {
        if (root == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(root);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void breadthBal(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitBal(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void breadthLevel(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisitLevel(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(ArrayList<Book> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder(t, p.left);
        t.add(p.info);
        inOrder(t, p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void inOrder2(ArrayList<Book> t, Node p) {
        if (p == null) {
            return;
        }
        inOrder2(t, p.left);
        t.add(p.info);
        inOrder2(t, p.right);
    }

    void bal(ArrayList<Book> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        insert(t.get(k));
        bal(t, i, k - 1);
        bal(t, k + 1, j);
    }

    void bal() {
        ArrayList<Book> t = new ArrayList<Book>();
        inOrder2(t, root);
        int n = t.size();
        clear();
//        insert(t.get(1));insert(t.get(0));t.remove(0);t.remove(0);insertMany(t);
        bal(t, 0, n - 1);
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            return (p);
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return (q);
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            return (p);
        }
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return (q);
    }

    void balance(ArrayList<Book> t, int i, int j) {
        if (i > j) {
            return;
        }
        int k = (i + j) / 2;
        insert(t.get(k));
        balance(t, i, k - 1);
        balance(t, k + 1, j);
    }

    void balance() {
        ArrayList<Book> t;
        t = new ArrayList<Book>();
        inOrder(t, root);
        int n = t.size();
        clear();
        balance(t, 0, n - 1);
    }

    void deleByCopy(String xcode) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.bcode.equals(xcode)) {
                break;
            }
            f = p;
            if (xcode.compareTo(p.info.bcode) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return;  // not found
        }
        // p is the leaf node
        if (p.left == null && p.right == null) {
            if (f == null) // p =root
            {
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                }
                f.right = null;
            }
            return;
        }

        // p has right child only
        if (p.left == null && p.right == null) {
            if (f == null) //p=root
            {
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                }
                f.right = p.right;
            }
            return;
        }

        // p has   both 2 children
        if (p.left != null && p.right != null) {  //find the right most node
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            //rp is the right most node on the left child
            p.info = rp.info;
            if (frp == null) // rp = q
            {
                p.left = q.left;
            } else {
                frp.right = rp.left;
            }
        }
    }

    void inOrderToFile(Node p) throws Exception {
        ArrayList<Book> t = new ArrayList<>();
        if (p == null) {
            return;
        }
        inOrder2(t, p.left);
        t.add(p.info);
        inOrder2(t, p.right);
    }

    void writeFile(String s) throws Exception {
        if (s == "") {
            return;
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            File file = new File("testout.txt");//check file, if not exits > create
            if (!file.exists()) {
                file.createNewFile();
            }
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write("\r\n");
            bw.write(s);
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bw.close();
            fw.close();
        }
    }

}
