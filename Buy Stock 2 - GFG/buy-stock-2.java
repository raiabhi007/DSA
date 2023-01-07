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
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int N){
        long ans = 0;
        long buy = prices[0];
        for(int i=1;i<N;i++){
            if(prices[i]<prices[i-1]){
            ans+=(prices[i-1]-buy);    
            buy = prices[i];
            }
        }
        if(prices[N-1]-buy>0)
        ans+=(prices[N-1]-buy);
        return ans;
    }
}