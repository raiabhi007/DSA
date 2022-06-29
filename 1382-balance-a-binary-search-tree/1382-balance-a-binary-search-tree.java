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
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode construct(ArrayList<Integer> list,int low,int high){
        if(low>high)
            return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = construct(list,low,mid-1);
        root.right = construct(list,mid+1,high);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);
        root = construct(list,0,list.size()-1);
        return root;
        
    }
}