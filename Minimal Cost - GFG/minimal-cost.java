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
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int arr[],int N,int K){
       int[] dp = new int[N];
       dp[0] = 0;
       dp[1] = Math.abs(arr[1]-arr[0]);
       for(int i=2;i<N;i++){
           int min = Integer.MAX_VALUE;
           for(int j=1;j<=K;j++){
               if(j>i)
               break;
               int temp = Math.abs(arr[i]-arr[i-j])+dp[i-j];
               min = Math.min(min,temp);
           }
           dp[i] = min;
       }
       return dp[N-1];
    }
    // public int helper(int arr[],int N,int K,int[] dp){
    //      if(N==1)
    //     return 0;
    //     if(N==2)
    //     return dp[N-1]=Math.abs(arr[1]-arr[0]);
    //     if(dp[N-1]!=-1)
    //     return dp[N-1];
    //     int min = Integer.MAX_VALUE;
    //     for(int j=1;j<=K;j++){
    //         if(j>=N){
    //             break;
    //         }
    //         int temp = Math.abs(arr[N-1]-arr[N-1-j])+helper(arr,N-j,K,dp);
    //         min = Math.min(temp,min);
    //     }
    //     return dp[N-1]=min;
    // }
}
