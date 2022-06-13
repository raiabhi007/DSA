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
    int dif = 0;
    public boolean isBalanced(TreeNode root) {
       helper(root);
        return dif<=1;
    }
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        int ls = helper(root.left);
        int rs = helper(root.right);
        
        dif = Math.max(dif,Math.abs(ls-rs));
        return Math.max(ls,rs)+1;
    }    
}