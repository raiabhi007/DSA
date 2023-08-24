//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int total_cost(int[][] cost){
        int n = cost.length;
        int dp[][] = new int[n][(int)Math.pow(2,n)];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(cost,0,1,cost.length,dp);
    }
    int solve(int[][] container,int city, int stats,int n,int[][] dp){
        if((stats==((1<<n)-1))) return container[city][0];
        if(dp[city][stats]!=-1) return dp[city][stats];
        int ans = Integer.MAX_VALUE;
        for(int choice=1;choice<n;choice++){
            if((stats&(1<<choice))==0){
                int cost = container[city][choice]+solve(container,choice,(stats|(1<<choice)),n,dp);
                ans = Math.min(ans,cost);
            }
        }
        return dp[city][stats]=ans;
    }
}