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
    public TreeNode helper(int[] pre,int start,int end){    
        if(start>end)
            return null;
        TreeNode root = new TreeNode(pre[start]);
        if(start==end)
            return root;
        int midIndex = -1;
        for(int i=start+1;i<=end;i++){
            if(pre[i]>pre[start]){
                midIndex = i;
                break;
            }    
        }        
        int leftS=start+1;
        int leftE= midIndex-1;
        int rightS=midIndex;
        int rightE=end;
        if(midIndex==-1){
            root.left = helper(pre,start+1,end);
            root.right = null;
        }else if(midIndex==start+1){
            root.left = null;
            root.right = helper(pre,start+1,end);
        }else{
        root.left = helper(pre,leftS,leftE);
        root.right = helper(pre,rightS,rightE);
        }
        return root;
    }
}