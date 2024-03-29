//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][]){
       int dp[][] = new int[N][N];
       int ans = Integer.MIN_VALUE;
       for(int j=0;j<N;j++){
       dp[0][j] = Matrix[0][j];
       ans = Math.max(dp[0][j],ans);
       }
       for(int i=1;i<N;i++){
           for(int j=0;j<N;j++){
               if(j==0){
                   dp[i][j] = Matrix[i][j]+Math.max(dp[i-1][j],dp[i-1][j+1]);
               }else if(j==N-1)
                   dp[i][j] = Matrix[i][j]+Math.max(dp[i-1][j],dp[i-1][j-1]);
                else{
                   dp[i][j] = Matrix[i][j]+Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i-1][j+1]));
                }
                ans = Math.max(ans,dp[i][j]);
           }
       }
       return ans;
    }
}