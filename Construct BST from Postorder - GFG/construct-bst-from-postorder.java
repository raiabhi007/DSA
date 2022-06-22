// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}
// } Driver Code Ends

class GFG
{
    public static Node constructTree(int post[],int n){
        return helper(post,0,n-1);
    }
    public static Node helper(int[] post,int start,int end){
        if(start>end)
        return null;
        Node root = new Node(post[end]);
        if(start==end)
        return root;
        int midIndex = -1;
        for(int i=start;i<end;i++){
            if(post[i]>post[end]){
                midIndex = i;
                break;
            }
        }
        int leftS = start;
        int leftE = midIndex-1;
        int rightS = midIndex;
        int rightE = end-1;
        if(midIndex==-1){
            root.left = helper(post,start,end-1);
            root.right = null;
        }else if(midIndex==start){
            root.left = null;
            root.right = helper(post,start,end-1);
        }else{
            root.left = helper(post,start,midIndex-1);
            root.right = helper(post,midIndex,end-1);
        }
        return root;
    }
}