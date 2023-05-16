import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public void req(List<List<Integer>> tree,  List<TreeNode> small)
    {
        List<TreeNode> tmp = new ArrayList<>();
        List<Integer> children = new ArrayList<>();
        for (TreeNode node : small)
        {
            if(node != null) {
                children.add(node.val);
                tmp.add(node.left);
                tmp.add(node.right);
            }
        }
        if (children.size() > 0) {
            tree.add(children);
            req(tree, tmp);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        List<TreeNode> small = new ArrayList<>();
        if (root != null) {
            tree.add(new ArrayList<>(Arrays.asList(root.val)));
            small.add(root.left);
            small.add(root.right);
            req(tree, small);
        }
        return tree;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

//[[3],[9,20],[6,5,15,7],[12,1,5,6]]