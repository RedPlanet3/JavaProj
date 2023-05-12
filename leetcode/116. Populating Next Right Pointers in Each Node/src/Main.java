/*
// Definition for a Node.

 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


public class Main {
    public Node connect(Node root) {
        Node answ = root;
        Node tmpLeft;
        while (root != null) {
            tmpLeft = root.left;
            while (root != null && root.left != null) {
                    root.left.next = root.right;
                if (root.next != null)
                    root.right.next = root.next.left;
                root = root.next;
            }
            root = tmpLeft;
        }
        return answ;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null, null),
                        new Node(5, null, null, null), null),
                new Node(3,
                        new Node(6, null, null, null),
                        new Node(7, null, null, null), null),
                null);
        Node dss = ds.connect(root);
        System.out.println();
    }
}
