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
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = start;
        while(head!=null){
            if(head.val==val){
                prev.next = head.next;
                head = head.next;
                continue;
            }
            head = head.next;
            prev = prev.next;
        }
        return start.next;
    }
}