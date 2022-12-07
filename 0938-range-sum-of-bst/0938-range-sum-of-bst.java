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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        int leftSum = 0;
        int rightSum = 0;
        if(root.val>=low&&root.val<=high){
            leftSum = rangeSumBST(root.left,low,high);
            rightSum = rangeSumBST(root.right,low,high);
            return root.val+leftSum+rightSum;
        }
        else if(root.val<low){
            return rangeSumBST(root.right,low,high);
        }
        else{
            return rangeSumBST(root.left,low,high);
        }
    }
}