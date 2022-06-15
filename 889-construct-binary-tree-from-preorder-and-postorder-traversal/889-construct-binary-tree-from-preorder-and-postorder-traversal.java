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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return buildTree(pre,post,0,pre.length-1,0,post.length-1);
    }
    public TreeNode buildTree(int[] pre,int[] post,int preS,int preE,int postS,int postE){
        if(preS>preE)
            return null;
        TreeNode root = new TreeNode(pre[preS]);
        if(preS==preE)
            return root;
        int idx = postS;
        for(int i=postS;i<=postE;i++){
            if(post[i]==pre[preS+1]){
                idx = i;
                break;
            }
        }
        int tnel = idx-postS+1;
        int leftPreS = preS+1;
        int leftPreE = preS+tnel;
        int leftPostS = postS;
        int leftPostE = idx;
        int rightPreS = leftPreE+1;
        int rightPreE = preE;
        int rightPostS = leftPostE+1;
        int rightPostE = postE-1;
        
        root.left = buildTree(pre,post,leftPreS,leftPreE,leftPostS,leftPostE);
        root.right = buildTree(pre,post,rightPreS,rightPreE,rightPostS,rightPostE);
        return root;
    }
}