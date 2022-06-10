// { Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}
// } Driver Code Ends

public class Pair{
    Node node = null;
    int h1 = 0;
    Pair(Node node,int h1){
        this.node = node;
        this.h1 = h1;
    }
}
class Solution
{
    static ArrayList <Integer> verticalOrder(Node root){
         ArrayList<Integer> ans = new ArrayList<>();
         if(root==null)
         return ans;
         HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
         int maxh1 = 0;
         int minh1 = 0;
         Queue<Pair> q = new LinkedList<>();
         q.add(new Pair(root,0));
         while(!q.isEmpty()){
             int size = q.size();
             while(size-->0){
                 Pair temp = q.poll();
                 maxh1 = Math.max(maxh1,temp.h1);
                 minh1 = Math.min(minh1,temp.h1);
                 map.putIfAbsent(temp.h1,new ArrayList<Integer>());
                 map.get(temp.h1).add(temp.node.data);
                 if(temp.node.left!=null)
                 q.add(new Pair(temp.node.left,temp.h1-1));
                 if(temp.node.right!=null)
                 q.add(new Pair(temp.node.right,temp.h1+1));
             }
         }
         for(int i=minh1;i<=maxh1;i++){
             for(int j:map.get(i))
             ans.add(j);
         }
         return ans;
    }
}