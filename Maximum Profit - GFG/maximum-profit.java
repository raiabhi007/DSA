//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int arr[]) {
        if(arr.length==0)
         return 0;   
        int[][] dp = new int[k+1][n];
        for(int t=1;t<=k;t++){
            int max = Integer.MIN_VALUE;
            for(int d=1;d<arr.length;d++){
                if(dp[t-1][d-1]-arr[d-1]>max)
                    max = dp[t-1][d-1] - arr[d-1];
                if(max+arr[d]>dp[t][d-1])
                    dp[t][d] = max + arr[d];
                else
                    dp[t][d] = dp[t][d-1];
            }
        }
        return dp[k][n-1];
    }
}