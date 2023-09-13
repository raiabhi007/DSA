//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int k, int n) 
	{
	     int dp[][] = new int[n+1][k+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        return helper(k,n,dp);
	}
	 public static int helper(int k,int n,int[][] dp){
        if(n==0||k==0) return 0;
        if(n==1) return 1;
        if(k==1) return n;
        if(dp[n][k]!=-1) return dp[n][k];
        
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            int survive = helper(k,n-i,dp);
            int drop = helper(k-1,i-1,dp);
            int temp = Math.max(survive,drop);
            ans = Math.min(ans,temp);
        }
        return dp[n][k]=1+ans;
    }
}