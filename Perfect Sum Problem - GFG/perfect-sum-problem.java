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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    // } Driver Code Ends


class Solution{
    int mod = 1000000007;
	public int perfectSum(int arr[],int n, int sum){ 
	   int[][] dp = new int[n+1][sum+1];
	   for(int i=0;i<=n;i++){
	       for(int j=0;j<=sum;j++)
	       dp[i][j] = -1;
	   }
	   
	   return perfectSumHelper(arr,n,sum,dp)%mod;
	} 
	public int perfectSumHelper(int[] arr,int n,int sum,int[][] dp){
	   if(n==0)
	   return dp[n][sum]=(sum==0)?1:0;
	
	   if(dp[n][sum]!=-1)
	   return dp[n][sum]%mod;
	   
	   if(arr[n-1]>sum)
	   return dp[n][sum] = (perfectSumHelper(arr,n-1,sum,dp))%mod;
	   
	   return dp[n][sum] = perfectSumHelper(arr,n-1,sum,dp)%mod+perfectSumHelper(arr,n-1,sum-arr[n-1],dp)%mod;
	}
}