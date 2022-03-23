// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends
class Solution{
    static int equalPartition(int N, int arr[]){
        long sumOfAllElements = 0;
        for(int i=0;i<N;i++){
            sumOfAllElements+=arr[i];
        }
        if(sumOfAllElements%2!=0)
        return 0;
        int sum = (int)sumOfAllElements/2;
        boolean dp[][] = new boolean[N+1][sum+1];
        dp[0][0] = true;
        
        for(int i=1;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(j==0)
                dp[i][j] = true;
                else if(arr[i-1]>j)
                dp[i][j] = dp[i-1][j];
                else{
                    if(dp[i-1][j-arr[i-1]]||dp[i-1][j])
                    dp[i][j] = true;
                    else
                    dp[i][j] = false;
                }
            }
        }
        return dp[N][sum]?1:0;
    }
}