// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends
class Solution{
    public int cutRod(int price[], int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        return helper(price,n,dp);
    }
    public int helper(int price[],int n,int dp[]){
        if(dp[n]!=-1)
        return dp[n];
        
        int ans = 0;
        for(int i=0;i<n;i++){
            int temp = price[i] +  helper(price,n-(i+1),dp);
            ans = Math.max(temp,ans);
        }
        return dp[n] = ans;
    }
}