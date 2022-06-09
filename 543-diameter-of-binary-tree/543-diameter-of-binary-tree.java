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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return Math.max(leftHeight+rightHeight,Math.max(left,right));
    }
    public int height(TreeNode node){
        if(node==null)
            return 0;
        int left = height(node.left);
        int right = height(node.right);
        
        return Math.max(left,right)+1;
    }
}