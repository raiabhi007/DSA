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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.add(root);
        while(!st1.isEmpty() || !st2.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            while(!st1.isEmpty()){
                TreeNode cur = st1.pop();
                subList.add(cur.val);
                if(cur.left!=null)
                    st2.push(cur.left);
                if(cur.right!=null)
                    st2.push(cur.right);
            }
            ans.add(subList);
            subList = new ArrayList<>();
            while(!st2.isEmpty()){
                TreeNode cur = st2.pop();
                subList.add(cur.val);
                if(cur.right!=null)
                    st1.push(cur.right);
                if(cur.left!=null)
                    st1.push(cur.left);
            }
            if(subList.size()!=0)
                ans.add(subList);
        }
        return ans;
    }
}