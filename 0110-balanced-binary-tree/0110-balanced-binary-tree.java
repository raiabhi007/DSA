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
    int diff = 0;
    public boolean isBalanced(TreeNode root) {
        helper(root);
            return diff<=1;
    }
    int helper(TreeNode root){
        if(root==null)
        return 0;
        if(root.left==null&&root.right==null)
        return 1;
        int l = helper(root.left);
        int r = helper(root.right);
        diff = Math.max(diff,Math.abs(l-r));
        return Math.max(l,r)+1;
    }
}