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
        boolean[][] dp = new boolean[N+1][sum+1];
        dp[0][0] = true;
        for(int i=1;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(j==0)
                dp[i][j] = true;
                else if(j-arr[i-1]<0)
                dp[i][j] = dp[i-1][j];
                else{
                 if(dp[i-1][j-arr[i-1]]==true||dp[i-1][j]==true)
                 dp[i][j] = true;
                 else
                 dp[i][j] = false;
                }
            }
        }
        return dp[N][sum];
    }
}