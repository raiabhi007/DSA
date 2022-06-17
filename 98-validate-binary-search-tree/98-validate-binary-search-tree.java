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
public class BSTPair{
    long min;
    long max;
    boolean isBST;
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        BSTPair ans = isValidBSTHelper(root);
        return ans.isBST;
    }
    public BSTPair isValidBSTHelper(TreeNode root){
        if(root==null){
            BSTPair base = new BSTPair();
            base.min = Long.MAX_VALUE;
            base.max = Long.MIN_VALUE;
            base.isBST = true;
            return base;
        }
        BSTPair lp = isValidBSTHelper(root.left);
        BSTPair rp = isValidBSTHelper(root.right);
        
        BSTPair mp = new BSTPair();
        mp.min = Math.min(Math.min(lp.min,rp.min),root.val);
        mp.max = Math.max(Math.max(lp.max,rp.max),root.val);
        if(lp.isBST&&rp.isBST&&lp.max<root.val&&rp.min>root.val)
            mp.isBST=true;
        else
            mp.isBST=false;
        return mp;
    }
}