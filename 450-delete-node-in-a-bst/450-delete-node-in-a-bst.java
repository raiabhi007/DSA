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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(key>root.val)
            root.right = deleteNode(root.right,key);
        else if(key<root.val)
            root.left = deleteNode(root.left,key);
        else{
            //zero children
            if(root.left==null&&root.right==null)
                return null;
            //single children
            else if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            //Two Children
            else{
                int maxInLeftSubtree = max(root.left);
                root.val = maxInLeftSubtree;
                root.left = deleteNode(root.left,maxInLeftSubtree);
            }
        }
            return root;
    }
    public int max(TreeNode root){
        if(root.right==null)
            return root.val;
        return max(root.right);
    }
}