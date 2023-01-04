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
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >triangle) {
         int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0;i<triangle.size();i++)
            Arrays.fill(dp[i],-1);
        int ans = helper(0,0,triangle,dp);
        return ans;
    }
    static int helper(int i,int j,ArrayList<ArrayList<Integer>>triangle,int[][] dp){
        if(i>=triangle.size())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int first = helper(i+1,j,triangle,dp);
        int second = helper(i+1,j+1,triangle,dp);
        
        return dp[i][j]=triangle.get(i).get(j) + Math.min(first,second);
        
    }
}