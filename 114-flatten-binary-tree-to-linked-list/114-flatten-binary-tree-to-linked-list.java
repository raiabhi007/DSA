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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        helper(root);
    }
     public TreeNode helper(TreeNode root){
        TreeNode leftNode = null;
        TreeNode rightNode = null;    
        if(root.left!=null)
        leftNode = helper(root.left);
        if(root.right!=null)
        rightNode = helper(root.right);
        
        TreeNode right = root.right;
        if(root.left!=null){
            TreeNode left = root.left;
            root.left = null;
            root.right = left;
            leftNode.right = right;
            return rightNode!=null?rightNode:leftNode;
        }
        return rightNode!=null?rightNode:root;
    }
}