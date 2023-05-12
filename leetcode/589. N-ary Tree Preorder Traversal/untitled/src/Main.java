import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class Main {
    public void req(Node root, List<Integer> tree)
    {
        tree.add(root.val);
        for (Node child : root.children)
        {
            if (child != null)
                req(child, tree);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> tree = new ArrayList<>();
        if (root != null) req(root, tree);
        return tree;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}