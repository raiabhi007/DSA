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
    public int goodNodes(TreeNode root) {
        return helper(root,-10000);
    }
    public int helper(TreeNode root, int max){
        if(root==null)
            return 0;
        int ans = 0;
        if(root.val>=max) ans+=1;
        int left = helper(root.left,Math.max(root.val,max));
        int right = helper(root.right,Math.max(root.val,max));
        return ans+left+right;
        
    }
}