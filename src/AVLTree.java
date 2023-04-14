

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class AVLTree {

    private int size;
    public Node root;

    public AVLTree() {
        this.size = 0;
        this.root = null;
    }

    Node maxValue(Node root) {

        while (root.right != null) {
            root = root.right;

        }
        return root;

    }

    void visit(Node p) {
        System.out.println(" " + p.info);

    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int height(Node p) {
        return p == null ? -1 : 1 + Math.max(height(p.left), height(p.right));
    }

    private int balanceFactor(Node p) {
        if (p == null) {
            return 0;
        }
        return height(p.right) - height(p.left);
    }

    private Node balance(Node p) {
        if (balanceFactor(p) == 2) {
            if (balanceFactor(p.right) < 0) {
                p.right = rightRotate(p.right);
            }
            return leftRotate(p);
        } else if (balanceFactor(p) == -2) {
            if (balanceFactor(p.left) > 0) {
                p.left = leftRotate(p.left);
            }
            return rightRotate(p);
        }
        return p;
    }

    public void insert(Phone x) {
        root = insert(root, x);
    }

    private Node insert(Node p, Phone x) {
        if (p == null) {
            return new Node(x);
        }
        if (p.info.ID == x.getID()) {
            return p;
        }

        if (x.ID < p.info.ID) {
            p.left = insert(p.left, x);
        } else {
            p.right = insert(p.right, x);
        }
        return balance(p);
    }

    private Node rightRotate(Node p) {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }

    private Node leftRotate(Node p) {
        Node q = p.right;
        p.right = q.left;
        q.left = p;
        return q;
    }

    private Node rotateWithLeftChild(Node k2) {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private Node rotateWithRightChild(Node k1) {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    Node minValueNode(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    private Node doubleWithLeftChild(Node k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private Node doubleWithRightChild(Node k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    public void preOrder() {
        preOrder(root);
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.info + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(Node p) {
        if (p != null) {
            inOrder(p.left);
            visit(p);
            inOrder(p.right);
        }
    }

    public void postOrder() {
        inOrder(root);
    }

    public void postOrder(Node p) {
        if (p != null) {
            inOrder(p.left);
            inOrder(p.right);
            visit(p);
        }
    }

    void breadth() throws Exception {
        if (root == null) {
            return;
        }
        ArrayQueue q = new ArrayQueue();
        q.enqueue(root);
        Node p;
        while (!q.isEmpty()) {
            p = (Node) q.dequeue();
            if (p.left != null) {
                q.enqueue(p.left);
            }
            if (p.right != null) {
                q.enqueue(p.right);
            }
            visit(p);
        }

    }

    void search(int x) {
        search(root, x);
    }

    Node search(Node p, int x) {
        if (p == null) {
            return (null);
        }
        if (p.info.ID == x) {
            return (p);
        }
        if (x < p.info.ID) {
            return (search(p.left, x));
        } else {
            return (search(p.right, x));
        }
    }

    public Phone find_Min_price() {
        Node node = find_Min_price(root);
        return node == null ? null : node.getInfo();
    }

    Node find_Min_price(Node node) {

        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }
        Phone min = node.getInfo();
        if (node.left != null) {
            Phone leftPhone = find_Min_price(node.left).getInfo();
            if (leftPhone.price < min.price) {
                min = leftPhone;
            }

        }
        if (node.right != null) {
            Phone rightPhone = find_Min_price(node.right).getInfo();
            if (rightPhone.price < min.price) {
                min = rightPhone;
            }
        }
        return new Node(min);

    }

    Phone find_Newest_Phone() {
        if (root == null) {
            return null;
        }

        Node current = root;
        Node newestNode = null;

        while (current != null) {
            if (newestNode == null || newestNode.info.year < current.info.year) {
                newestNode = current;
            }
            current = current.left;
        }

        return newestNode.info;
    }

    public Phone find_Max_price() {
        Node node = find_Max_price(root);
        return node == null ? null : node.getInfo();
    }

    Node find_Max_price(Node node) {

        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }
        Phone max = node.getInfo();
        if (node.left != null) {
            Phone leftPhone = find_Max_price(node.left).getInfo();
            if (leftPhone.price > max.price) {
                max = leftPhone;
            }

        }
        if (node.right != null) {
            Phone rightPhone = find_Max_price(node.right).getInfo();
            if (rightPhone.price > max.price) {
                max = rightPhone;
            }
        }
        return new Node(max);
    }

    public void deleteNode(int x) {
        root = deleteNode(root, x);
    }

    private Node deleteNode(Node p, int x) {
        if (p == null) {
            return p;
        }
        if (x < p.info.ID) {
            p.left = deleteNode(p.left, x);
        } else if (x > p.info.ID) {
            p.right = deleteNode(p.right, x);
        } else {
            // Found the node to be deleted
            if (p.left == null || p.right == null) {
                // Case 1: Node has 0 or 1 child
                Node temp = null;
                if (p.left == null) {
                    temp = p.right;
                } else {
                    temp = p.left;
                }
                if (temp == null) {
                    // Node has no child
                    temp = p;
                    p = null;
                } else {
                    // Node has one child
                    p = temp;
                }
            } else {
                // Case 2: Node has 2 children
                Node temp = minValueNode(p.right);
                p.info = temp.info;
                p.right = deleteNode(p.right, temp.info.ID);
            }
        }
        if (p == null) {
            return p;
        }
        p = balance(p);
        return p;
    }

    public void deleteByCopying(int x) {
        root = deleteByCopying(root, x);
    }

    private Node deleteByCopying(Node p, int x) {
        if (p == null) {
            return p;
        }
        if (x < p.info.ID) {
            p.left = deleteByCopying(p.left, x);
        } else if (x > p.info.ID) {
            p.right = deleteByCopying(p.right, x);
        } else {
            // Found the node to be deleted
            if (p.left == null) {
                p = p.right;
            } else if (p.right == null) {
                p = p.left;
            } else {
                Node temp = p.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = p.right;
                p = p.left;
            }
        }
        if (p == null) {
            return p;
        }
        p = balance(p);
        return p;
    }

    public void deleteByMerging(int x) {
        root = deleteByMerge(root, x);
    }

    private Node deleteByMerge(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (x < root.info.ID) {
            root.left = deleteByMerge(root.left, x);
        } else if (x > root.info.ID) {
            root.right = deleteByMerge(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            }
            Node cur;
            cur = maxValue(root.left);
            cur.right = root.right;
            root = root.left;
            root.left = deleteByMerge(root.left, x);
        }
        root = balance(root);
        return root;
    }

    public static void main(String[] args) throws Exception {
        AVLTree m = new AVLTree();
        Node root = null;

        m.insert(new Phone(1, "Nam", 2, 2009, 2));
        m.insert(new Phone(2, "Hung", 7, 2006, 3));
        m.insert(new Phone(3, "Cuong", 9, 2007, 1));
        m.insert(new Phone(4, "Thanh", 6, 1998, 3));
        m.insert(new Phone(6, "Vinh", 1, 1994, 6));
        m.insert(new Phone(9, "Hao", 1, 1994, 7));
        m.breadth();
        System.out.println("Search:");
        System.out.println(m.search(m.root, 6));

        System.out.println("Min:");
        System.out.println("" + m.find_Min_price());
        System.out.println("Max:");
        System.out.println("" + m.find_Max_price());

        System.out.println("Delete Copying:");
        m.deleteByCopying(4);
        m.breadth();

        System.out.println("Delete Merging:");
        m.deleteByMerging(5);
        m.breadth();

        System.out.println("Delete Node:");
        m.deleteNode(6);
        m.breadth();
    }

}
