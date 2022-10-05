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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
         if (depth == 0 || depth == 1) {
            TreeNode newroot = new TreeNode(val);
            newroot.left = depth == 1 ? root : null;
            newroot.right = depth == 0 ? root : null;
            return newroot;
        }
        if (root != null && depth >= 2) {
            root.left  = addOneRow(root.left,  val, depth > 2 ? depth - 1 : 1);
            root.right = addOneRow(root.right, val, depth > 2 ? depth - 1 : 0);
        }
        return root;
    }
}