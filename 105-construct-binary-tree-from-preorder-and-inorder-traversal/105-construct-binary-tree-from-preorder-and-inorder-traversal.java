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
    public TreeNode buildTree(int[] pre, int[] in) {
        return build(pre,in,0,pre.length-1,0,in.length-1);
    }
    public TreeNode build(int[] pre,int[] in,int preS,int preE,int inS,int inE){
        if(preE<preS)
            return null;
        TreeNode root = new TreeNode(pre[preS]);
        if(preS==preE)
            return root;
        int idx = inS;
        for(int i = inS;i<=inE;i++){
            if(in[i]==pre[preS]){
                idx = i;
                break;
            }                
        }
        int leftPreS = preS+1;
        int leftPreE = preS+idx-inS;
        int leftInS = inS;
        int leftInE = idx-1;
        int rightPreS = leftPreE+1;
        int rightPreE = preE;
        int rightInS = idx+1;
        int rightInE = inE;
        
        root.left = build(pre,in,leftPreS,leftPreE,leftInS,leftInE);
        root.right = build(pre,in,rightPreS,rightPreE,rightInS,rightInE);
        return root;
            
    }
}