//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int M=sc.nextInt();
            
            int [][]grid=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    grid[i][j]=sc.nextInt();
                    
                }
            }
            
            Solution obj=new Solution();
            long res=obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends

class Solution{
    public int solve(int n, int m, int grid[][]){
        int[][][] dp = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++)
                dp[i][j][k]=-1;
            }
        }
        return helper(0,0,m-1,n,m,grid,dp);
    }
    public int helper(int i,int j1,int j2,int n,int m,int[][] grid,int[][][] dp){
        if(j1<0||j1>=m||j2<0||j2>=m)
        return (int)Math.pow(-10,9);
        if(i==n-1){
            if(j1==j2)
            return grid[i][j1];
            else
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1)
        return dp[i][j1][j2];
        int maxi=Integer.MIN_VALUE;
        
        for(int di=-1;di<=1;di++){
            for(int dj=-1;dj<=1;dj++){
                int ans;
                if(j1==j2)
                ans = grid[i][j1]+helper(i+1,j1+di,j2+dj,n,m,grid,dp);
                else
                ans = grid[i][j1]+grid[i][j2]+helper(i+1,j1+di,j2+dj,n,m,grid,dp);
                maxi = Math.max(maxi,ans);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
} 