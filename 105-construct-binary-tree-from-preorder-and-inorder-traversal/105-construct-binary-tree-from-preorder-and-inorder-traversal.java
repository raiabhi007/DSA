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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] in,int[] pre,int inS,int inE,int preS,int preE){
        if(inS>inE)
            return null;
        int rootData = pre[preS];
        TreeNode root = new TreeNode(rootData);
        int rootIndex = -1;
        for(int i=inS;i<=inE;i++){
            if(in[i]==rootData){
                rootIndex = i;
                break;
            }
        }        
        int leftInS = inS;
        int leftInE = rootIndex-1;
        int leftPreS = preS+1;
        int leftPreE = leftPreS + leftInE-leftInS;
        int rightInS = rootIndex+1;
        int rightInE = inE;
        int rightPreS = leftPreE+1;
        int rightPreE = preE;
        
        root.left = buildTreeHelper(in,pre,leftInS,leftInE,leftPreS,leftPreE);
        root.right = buildTreeHelper(in,pre,rightInS,rightInE,rightPreS,rightPreE);
        return root;
            
        
    }
}