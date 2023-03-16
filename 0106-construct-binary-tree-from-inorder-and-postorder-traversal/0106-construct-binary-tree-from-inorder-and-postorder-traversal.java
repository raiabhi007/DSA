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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] in,int[] post,int inS,int inE,int postS,int postE){
        if(inS>inE)
            return null;
        int rootData = post[postE];
        TreeNode root = new TreeNode(rootData);
        int rootIndex = -1;
        for(int i=inS;i<=inE;i++){
            if(rootData==in[i]){
                rootIndex = i;
                break;
            }
        }
        int leftInS = inS;
        int leftInE = rootIndex-1;
        int leftPostS = postS;
        int leftPostE = leftInE-leftInS+leftPostS;
        int rightInS = rootIndex+1;
        int rightInE = inE;
        int rightPostS = leftPostE+1;
        int rightPostE = postE-1;
        
        root.left = buildTreeHelper(in,post,leftInS,leftInE,leftPostS,leftPostE);
        root.right = buildTreeHelper(in,post,rightInS,rightInE,rightPostS,rightPostE);
        return root;
        
    }
}