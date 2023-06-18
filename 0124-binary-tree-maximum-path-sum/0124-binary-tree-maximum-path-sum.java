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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    int helper(TreeNode root){
        if(root==null)
            return 0;
        int lsum = helper(root.left);
        int rsum = helper(root.right);
        int sum1 = root.val+lsum+rsum;
        int sum2 = root.val+lsum;
        int sum3 = root.val+rsum;
        int sum4 = root.val;
        int maxi = Math.max(sum1,Math.max(sum2,Math.max(sum3,sum4)));
        max = Math.max(maxi,max);
        if(lsum<0&&rsum<0)
        return root.val;
        else
            return root.val+Math.max(lsum,rsum);
    }
}