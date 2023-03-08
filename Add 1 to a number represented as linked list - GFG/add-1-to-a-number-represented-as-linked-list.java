//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends

class Solution{
    public static Node addOne(Node head) { 
        head = reverseList(head);
        Node temp = head;
        int c =1;
        Node ans = new Node(-1);
        Node k = ans;
        while(temp != null ||c==1){
            int s=0;
            if(temp != null){
                s += temp.data;
                temp = temp.next;
            }
            s += c;
            c = s/10;
            Node cur = new Node(s%10);
            ans.next = cur;
            ans = ans.next;
        }
        return reverseList(k.next);
    }
    static Node reverseList(Node head){
        if (head == null || head.next == null)
            return head;            
        Node prev = null;
        Node temp = head;     
        while (temp != null){
            head = head.next;
            temp.next = prev;
            prev = temp;
            temp = head;
        }      
        return prev;
    }
}