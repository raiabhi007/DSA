/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node nex = null;
        for(cur = head;cur!=null;){
            nex = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = nex;
            cur = nex;
        }
        for(cur = head;cur!=null;){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node head1 = new Node(0);
        Node cur1 = head1;
        for(cur=head;cur!=null;){
            
            cur1.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            cur1 = cur1.next;
        }
        return head1.next;
    }
}