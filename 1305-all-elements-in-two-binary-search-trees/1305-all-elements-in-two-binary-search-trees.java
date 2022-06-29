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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        inorder(root1,list1);
        inorder(root2,list2);
        List<Integer> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i)<list2.get(j))
                ans.add(list1.get(i++));
            else
                ans.add(list2.get(j++));
        }
        while(i<list1.size())
            ans.add(list1.get(i++));
        while(j<list2.size())
            ans.add(list2.get(j++));
        return ans;
        
                
    }
}