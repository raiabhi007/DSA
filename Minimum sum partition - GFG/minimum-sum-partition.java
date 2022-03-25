// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    // } Driver Code Ends
class Solution
{
	public int minDifference(int arr[], int n){ 
	  int range = 0;
	  for(int i=0;i<n;i++){
	      range+=arr[i];
	  }
	  int temp = range/2;
	  boolean[][] dp = new boolean[n+1][temp+1];
	  for(int i=0;i<=n;i++){
	      for(int j=0;j<=temp;j++){
	          if(i==0){
	              if(j==0)
	              dp[i][j] = true;
	              else
	              dp[i][j] = false;
	          }
	          else if(j<arr[i-1])
	          dp[i][j] = dp[i-1][j];
	          else{
	              if(dp[i-1][j-arr[i-1]]==true||dp[i-1][j]==true)
	              dp[i][j] = true;
	              else
	              dp[i][j] = false;
	          }
	      }
	  }
	  int ans = Integer.MAX_VALUE;
	  for(int i=0;i<=temp;i++){
	      if(dp[n][i]==true)
	       ans = Math.min(ans,range-2*i);
	  }
	 	  return ans;
	} 
}
