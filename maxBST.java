import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    ArrayList<Integer> treeSums = new ArrayList<>();
    public int maxSumBST(TreeNode root) {
        createList(root);
        return Collections.max(treeSums);
    }

    private void createList(TreeNode root) {
        treeSums.add(0);
        if (root != null){
            if (isTree(root)){
                System.out.print(getSum(root) + " ");
                System.out.println(sum);
                treeSums.add(sum);
                sum = 0;
            }
            createList(root.left);
            createList(root.right);
        }
    }

    private boolean isTree(TreeNode root) {
        tree.clear();
        inOrder(root);
        for (int i = 1; i < tree.size(); i++) {
            if (tree.get(i - 1) >= tree.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> tree = new ArrayList<>();
    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            tree.add(root.val);
            sum += root.val;
            inOrder(root.right);
        }
    }

    private int getSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        return root.val + getSum(root.left) + getSum(root.right);
    }
}