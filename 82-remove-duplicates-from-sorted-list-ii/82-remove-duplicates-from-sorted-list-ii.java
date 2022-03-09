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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        int dup = Integer.MAX_VALUE;
        
        while(head.next!=null){
            if(dup==head.val){
                head = head.next;
                continue;
            }
            if(head.val==head.next.val)
                dup = head.val;
            else{
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }
        if(dup!=head.val)
            temp.next = head;
        else
            temp.next = null;
        return ans.next;
    }
}