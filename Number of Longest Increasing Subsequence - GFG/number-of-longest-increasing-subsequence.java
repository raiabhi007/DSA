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
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int N, int arr[]){
       int len[] = new int[N];
       int cnt[] = new int[N];
       for(int i=0;i<N;i++)
       len[i]=cnt[i] = 1;
       int max_len = 0;
       int res = 0;
       for(int i=0;i<N;i++){
           for(int j=0;j<i;j++){
               if(arr[i]>arr[j]){
                   if(len[i]==len[j]+1) cnt[i]+=cnt[j];
                   if(len[j]+1>len[i]){
                       len[i] = 1+len[j];
                       cnt[i] = cnt[j];
                   }
               }
           }
           if(max_len==len[i]) res+=cnt[i];
           if(max_len<len[i]){
               max_len = len[i];
               res = cnt[i];
           }
       }
       return res;
    }
}