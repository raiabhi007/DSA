//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int col[] = new int[n];
        int[] d1 = new int[2*n-1];
        int[] d2 = new int[2*n-1];
        backtrack(col,d1,d2,0,ans,list);
        return ans;
    }
    static void backtrack(int[] col,int[] d1,int[] d2,int r,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> list){
        int n = col.length;
        if(r==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int c=0;c<n;c++){
            if(col[c]==0&&d1[r+c]==0&&d2[r-c+n-1]==0){
                col[c] = 1;
                d1[r+c]=1;
                d2[r-c+n-1]=1;
                list.add(c+1);
                backtrack(col,d1,d2,r+1,ans,list);
                list.remove(list.size()-1);
                col[c]=0;
                d1[r+c] = 0;
                d2[r-c+n-1]=0;
            }
        }
    }
}