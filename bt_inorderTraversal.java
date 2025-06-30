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
    private ArrayList<Integer> valList = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        createList(root);
        return valList;
    }
    private void createList (TreeNode root) {
        if(root != null){
            if (root.left != null){createList(root.left);}
            valList.add(root.val);
            if (root.right != null){createList(root.right);}
        }
    }
}