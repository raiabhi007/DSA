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
    int k=-1;
    boolean printLevelOrder(TreeNode root)  
    { 
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        { 
            TreeNode tempNode = queue.poll(); 
          //  System.out.print(tempNode.data + " "); 
            if (tempNode.left != null) { 
                if(k==-1)
                queue.add(tempNode.left);
                else{
                    return false;
                }
            } 
            else{
                k=0;
            }
            if (tempNode.right != null) { 
                if(k==-1)
                queue.add(tempNode.right);
                else
                    return false;
            } 
            else
                k=0;
        }
        return true;
    } 
    public boolean isCompleteTree(TreeNode root) {
        return printLevelOrder(root);
    }
}