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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
    public TreeNode helper(int[] pre, int start,int end){
        if(end<start)
            return null;
        TreeNode root = new TreeNode(pre[start]);
        int idx = start+1;
        int i = start+1;
        for(i=start+1;i<=end;i++){
            if(pre[i]>root.val){
                idx = i;
                break;
            }
        }
        if(i>end)
            idx = end+1;
        root.left = helper(pre,start+1,idx-1);
        root.right = helper(pre,idx,end);
        return root;
    }
}