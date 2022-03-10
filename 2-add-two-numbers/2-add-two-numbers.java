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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans =  new ListNode(0);
        ListNode prev = ans;
        int carry = 0;
        
        while(l1!=null||l2!=null||carry!=0){
            int value1 = 0,value2 = 0;
            if(l1!=null){
                value1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                value2 = l2.val;
                l2 = l2.next;
            }
            int sum = value1+value2+carry;
            carry = sum/10;
            int value = sum%10;
            prev.next = new ListNode(value);
            prev = prev.next;
        }
        return ans.next;
    }
}