//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int mod = 1000000007;
    public int totalWays(int N, int M, int grid[][]) {
        if(grid[0][0]==1||grid[N-1][M-1]==1)
        return 0;
        int dp[][] = new int[N][M];
        dp[0][0] = 1;
        boolean flagRow = false;
        boolean flagCol = false;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i==0&&j==0) //base case
                continue;
                else if(i==0){
                    if(flagRow==true||grid[i][j]==1){
                        flagRow = true;
                        continue;
                    }
                    dp[i][j]=1;
                }else if(j==0){
                    if(grid[i][j]==1||flagCol==true){
                        flagCol = true;
                        continue;
                    }
                    dp[i][j]=1;
                }else{
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    if(grid[i-1][j]!=1)
                    dp[i][j]+=up;
                    if(grid[i][j-1]!=1)
                    dp[i][j]+=left;
                    dp[i][j] = dp[i][j]%mod;
                }
            }
        }
        return dp[N-1][M-1];
    }
}