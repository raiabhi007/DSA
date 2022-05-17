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
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode prev = null;
        ListNode current = head;
        ListNode nex;
        while(current!=null){
            nex = current.next;
            current.next = prev;
            prev = current;
            current = nex;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next==null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null&&fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        if(fast!=null)
            slow = slow.next;
        slow = reverse(slow);
        while(head!=null){
            if(head.val!=slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}