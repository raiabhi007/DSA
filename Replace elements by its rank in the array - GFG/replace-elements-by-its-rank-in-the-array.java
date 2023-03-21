//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Pair implements Comparable<Pair>{
    int data, index;
    public Pair(int data,int index){
        this.data=data;
        this.index=index;
    }
    public int compareTo(Pair obj){
        return this.data-obj.data ;
    }
}
public class Solution {
    static int[] replaceWithRank(int arr[], int n) {
        int temp[]=new int[n];
        PriorityQueue<Pair>list =new PriorityQueue<>();
        for (int i = 0; i < temp.length; i++) {
            list.add(new Pair(arr[i], i));
        }
        int inc=0,last=Integer.MIN_VALUE;
        for (int i = 0; i < temp.length; i++) {
            Pair p=list.poll();
            int data=p.data, index=p.index;
           if(data!=last){
            last=data;
            temp[index]=inc+=1;
           }else temp[index]=inc;
        }
        return temp;
   
     }
}
     