import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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

    public void addNode(LinkedList<TreeNode> queue, TreeNode node, int val, int left)
    {
        if (node == null) return;
        node.val = val * 2 - left;
        queue.add(node);
    }

    public int bfs(LinkedList<TreeNode> queue)
    {
        int maxCount = 1;
        int size = 1;
        while (size > 0) {
            while (size-- > 0) {
                TreeNode node = queue.poll();
                addNode(queue, node.left, node.val, 1);
                addNode(queue, node.right,node.val, 0);
            }
            size = queue.size();
            if (size > 0)
                maxCount = Math.max(queue.getLast().val - queue.getFirst().val + 1, maxCount);
        }
        return maxCount;
    }

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        root.val = 1;
        queue.offer(root);
        return bfs(queue);
    }


    public static void main(String[] args) {
        Main ds = new Main();
        TreeNode root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9)));
        System.out.println("4: " + ds.widthOfBinaryTree(root));

        root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
                new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)));
        System.out.println("7: " + ds.widthOfBinaryTree(root));

        root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), null),
                new TreeNode(2));
        System.out.println("2: " + ds.widthOfBinaryTree(root));

    }
}