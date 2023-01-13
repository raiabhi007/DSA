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
                prices[i]=sc.nextLong();
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
    public long maximumProfit(long arr[], int N){
        long obsp = -arr[0]; //old bought state profit
        long ossp = 0;       //old sold state profit
        long ocsp = 0;       // old cooldown state profit
        
        for(int i=1;i<N;i++){
            long nbsp = 0;   // new bought state profit
            long nssp = 0;   // new sold state profit
            long ncsp = 0;   // new cooldown state profit
            
            if(ocsp-arr[i]>obsp){
                nbsp = ocsp - arr[i];
            }else
                nbsp = obsp;
                
            if(obsp+arr[i]>ossp){
                nssp = obsp+arr[i];
            }else
               nssp = ossp;
            
            if(ocsp<ossp){
                ncsp = ossp;
            }else
               ncsp = ocsp;
               
               obsp = nbsp;
               ossp = nssp;
               ocsp = ncsp;
        }
        return ossp;
    }
}
