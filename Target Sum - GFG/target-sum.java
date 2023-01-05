//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] nums , int n, int target) {
        // code here
        int TotalSum = 0;
        for(int i=0;i<n;i++)
            TotalSum+=nums[i];
        
        if(TotalSum<Math.abs(target)||(TotalSum+target)%2!=0)
            return 0;
        int s1 = (TotalSum+target)/2;
        int dp[][] = new int[n+1][s1+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s1;j++){
                if(i==0){
                    if(j==0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 0;
                }
                else if(j<nums[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = (dp[i-1][j-nums[i-1]]+dp[i-1][j])%1000000007;
            }
        }
        return dp[n][s1];
    }
};