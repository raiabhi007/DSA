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
   public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode curr = root;
        while(curr != null){
            ++n;
            curr = curr.next;
        }
        int m = n/k, r = (n % k), j = 0;
        if(m == 0) r -= k;
        ListNode[] res = new ListNode[k];
        curr = root;
        while(curr != null){
            res[j++] = curr;
            for(int i=1; i < m; i++){
                curr = curr.next;
            }
            if(r > 0){
                curr = curr.next;
                --r;
            }
            ListNode tmp = curr.next;
            curr.next = null;
            curr = tmp;
        }
        return res;
    }
}