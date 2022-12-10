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
   long sum = 0;
    long max = 0;
    public int maxProduct(TreeNode root) {
        sum = sumOfTree(root);
        sumOfTree(root);
        return (int)(max%(1e9+7));
    }
    
    private long sumOfTree(TreeNode root){
        if(root == null)
            return 0;
    
        long subsum = sumOfTree(root.left)+sumOfTree(root.right) +root.val;
        max = Math.max(max,subsum *(sum - subsum));
        return subsum;
    }    
}