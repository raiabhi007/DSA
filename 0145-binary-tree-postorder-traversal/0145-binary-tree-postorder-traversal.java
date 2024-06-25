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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.add(root);
        
        while(!st1.isEmpty()){
            TreeNode cur = st1.pop();
            st2.add(cur);
            if(cur.left!=null)
                st1.add(cur.left);
            if(cur.right!=null)
                st1.add(cur.right);
        }
        while(!st2.isEmpty()){
            TreeNode cur = st2.pop();
            ans.add(cur.val);
        }
        return ans;
    }
}