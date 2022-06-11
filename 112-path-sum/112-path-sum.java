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
    boolean isLeaf(TreeNode root){
        return root.left==null&&root.right==null;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(targetSum-root.val==0&&isLeaf(root))
            return true;
        boolean leftAns = hasPathSum(root.left,targetSum-root.val);
        boolean rightAns = hasPathSum(root.right,targetSum-root.val);
        return leftAns||rightAns;
    }
}