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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int height[],int N){
       int[] dp = new int[N];
       dp[0] = 0;
       dp[1] = Math.abs(height[1]-height[0]);
       for(int i=2;i<N;i++){
           int first = Math.abs(height[i]-height[i-1])+dp[i-1];
           int second = Math.abs(height[i]-height[i-2])+dp[i-2];
           dp[i] = Math.min(first,second);
       }
       return dp[N-1];
    }
    // public int helper(int height[],int N,int[] dp){
    //      if(N==2)
    //     return dp[N-1]=Math.abs(height[1]-height[0]);
    //     if(N==1){
    //         return dp[N-1]=0;
    //     }
    //     if(dp[N-1]!=-1)
    //     return dp[N-1];
    //     int first = Math.abs(height[N-1]-height[N-2])+helper(height,N-1,dp);
    //     int second = Math.abs(height[N-1]-height[N-3])+helper(height,N-2,dp);
    //     return dp[N-1]=Math.min(first,second);
    // }
}