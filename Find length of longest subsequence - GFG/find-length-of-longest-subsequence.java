// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            String X = input_line[0];
            String Y = input_line[1];
            Solution obj = new Solution();
            int ans = obj.maxSubsequenceSubstring(X, Y, N, M); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends
class Solution 
{ 
    int maxSubsequenceSubstring(String X, String Y, int N, int M){
        int[][] dp = new int[N+1][M+1];
        int ans = 0;
        for(int i=0;i<=N;i++){
            for(int j=0;j<=M;j++){
                if(i==0||j==0)
                dp[i][j] = 0;
                else if(X.charAt(i-1)==Y.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else
                dp[i][j] = dp[i-1][j];
                ans = Math.max(dp[i][j],ans);
            }
        }
        return ans;
    }
} 