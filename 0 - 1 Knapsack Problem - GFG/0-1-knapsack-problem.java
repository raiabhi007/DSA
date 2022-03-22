// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends
class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helper(W,wt,val,n,dp);
    } 
    static int helper(int W,int wt[],int val[],int n,int[][] dp){
        if(n==0||W==0)
        return 0;
        if(dp[n][W]!=-1)
        return dp[n][W];
        else if(wt[n-1]>W)
        return dp[n][W] = helper(W,wt,val,n-1,dp);
        
        return dp[n][W] = Math.max(val[n-1]+helper(W-wt[n-1],wt,val,n-1,dp),helper(W,wt,val,n-1,dp));
        
    }
}


