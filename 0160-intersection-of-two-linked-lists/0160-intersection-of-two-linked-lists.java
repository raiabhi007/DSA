/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    int getDifference(ListNode head1,ListNode head2){
        int len1 = 0;
        int len2 = 0;
        while(head1!=null){
            head1 = head1.next;
            len1++;
        }
        while(head2!=null){
            head2 = head2.next;
            len2++;
        }
        return len1-len2;
    }
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int diff = getDifference(head1,head2);
        if(diff<0)
            while(diff++<0) head2 = head2.next;
        else
            while(diff-->0) head1 = head1.next;
        while(head1!=null){
            if(head1==head2) return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;
    }
}