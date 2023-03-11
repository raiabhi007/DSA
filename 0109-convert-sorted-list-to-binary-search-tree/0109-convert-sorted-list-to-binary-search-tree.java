/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    	ListNode head=null;
    public TreeNode sortedListToBST(ListNode head) {
		 int size=0;
		 ListNode curr = head;
		 while(curr!=null){
			size++;
			curr=curr.next;
		 }		 
		 this.head=head;
		 return sortedListToBST(0,size);
	 } 
	TreeNode sortedListToBST(int start, int end){
		if(start>=end) return null; 
		 if(start+1==end) {
			 TreeNode node = new TreeNode(head.val);
			 head=head.next; 
			 return node;
		 }
		int middle = (start+end)/2; 
		TreeNode left = sortedListToBST(start,middle); 
		TreeNode root = sortedListToBST(middle, middle+1);  
		TreeNode right = sortedListToBST(middle+1,end);
		root.left=left; root.right=right;		
		 
		return root;
	}
}