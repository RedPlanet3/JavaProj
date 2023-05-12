import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Definition for a binary tree node.
 * */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


public class Main {

     public void dfs(AtomicInteger count, boolean right, TreeNode start, AtomicInteger maxCount)
     {
         if (start != null)
         {
             count.set(count.get() + 1);
             right = !right;
             dfs(count, right, !right ? start.right : start.left, maxCount);
             right = !right;
             count.set(count.get() + 1);
             dfs(count, right, right ? start.left : start.right, maxCount);
         }
         else {
             maxCount.set(Math.max(maxCount.get(), count.get()));
             count.set(-1);
         }
     }

    public int longestZigZag(TreeNode root) {
        AtomicInteger count = new AtomicInteger(-1);
        AtomicInteger maxCount = new AtomicInteger(0);
        dfs(count, true, root, maxCount);
         return maxCount.get();
    }
//[1,нуль,1,1,1,нуль,нуль,1,1,нуль,1,нуль,нуль,нуль,1,нуль,1]
    public static void main(String[] args) {
        Main ds = new Main();
        TreeNode root = new TreeNode(1, null,
                new TreeNode(2, new TreeNode(3, null, null),
                        new TreeNode(4, new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7, null, new TreeNode(8)))),
                                new TreeNode(9, null, null))));
        System.out.println("3: " + ds.longestZigZag(root));
    }
}
