// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends
class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[N+1][sum+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j] = -1;
            }
        }
        int ans = subsetSum(N,arr,sum,dp);
        return ans==1;
    }
    static int subsetSum(int n,int[] arr,int sum,int[][] dp){
        if(sum==0)
        return 1;
        if(n==0)
        return 0;
        
        if(dp[n][sum]!=-1)
        return dp[n][sum];
        
        if(arr[n-1]>sum)
        return dp[n][sum] = subsetSum(n-1,arr,sum,dp);
        
        if (subsetSum(n-1,arr,sum,dp) !=0||subsetSum(n-1,arr,sum-arr[n-1],dp)!=0)
                return dp[n-1][sum] = 1;
            else
                return dp[n-1][sum] = 0;
    }
}