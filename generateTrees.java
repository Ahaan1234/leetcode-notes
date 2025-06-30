import java.util.*;
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = generate(1, n);
        return result;
    }
    private List<TreeNode> generate(int left, int right){
        if (left == right){
            return Arrays.asList(new TreeNode(left));
        }
        if (left > right){
            List<TreeNode> temp = new ArrayList<>();
            temp.add(null);
            return temp;
        }
        List<TreeNode> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            for(TreeNode leftTree : generate(left, i - 1)){
                for(TreeNode rightTree : generate(i+1, right)){
                    TreeNode root = new TreeNode(i, leftTree, rightTree);
                    result.add(root);
                }
            }
        }
        return result;
    }
}