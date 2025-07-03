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
    public boolean isValidBST(TreeNode root) {
        // ATTEMPT 1 - cool idea, doesn't work in depth. 
        // if (root == null) return true;
        // if (root.left == null && root.right == null) return true;
        // if (root.left != null){
        //     if (root.left.val == root.val) return false;
        //     if (root.left.val > root.val) return false;
        // }
        // if (root.right != null){
        //     if (root.right.val == root.val) return false;
        //     if (root.right.val < root.val) return false;
        // }
        // if (isValidBST(root.left) && isValidBST(root.right)) return true;
        // return false;

        inOrder(root);
        for (int i = 1; i < tree.size(); i++) {
            if (tree.get(i - 1) >= tree.get(i)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> tree = new ArrayList<>();
    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            tree.add(root.val);
            inOrder(root.right);
        }
    }
}