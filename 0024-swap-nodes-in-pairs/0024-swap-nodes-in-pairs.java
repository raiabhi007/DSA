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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode temp = head;

        while(temp.next != null) {
            // Swapping the values -->
            int num = temp.val;
            temp.val = temp.next.val;
            temp.next.val = num;

            if(temp.next.next != null) {
                temp = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}