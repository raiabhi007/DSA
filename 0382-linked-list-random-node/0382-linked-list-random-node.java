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
    ListNode head;
    int listLength = 0;
    int lastFetchedElementIndex;
    ListNode lastFetchedElement;
    Random random;

    public Solution(ListNode head) {
        random = new Random();
        this.head = head;
        lastFetchedElementIndex = 1;
        lastFetchedElement = head;

        while(head != null) {
            listLength++;
            head = head.next;
        }
    }

    public int getRandom() {
        int randomIndex = getRandomNumber();
        if (randomIndex < lastFetchedElementIndex) {
            lastFetchedElementIndex = 1;
            lastFetchedElement = head;
        }
        
        while (lastFetchedElementIndex < randomIndex) {
            lastFetchedElementIndex++;
            lastFetchedElement = lastFetchedElement.next;
        }
        
        return lastFetchedElement.val;
    }

    public int getRandomNumber() {
        return random.nextInt(listLength) + 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */