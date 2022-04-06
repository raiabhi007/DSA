// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends
class Solution 
{ 
    int minDeletions(String s, int n)
    {
        String t = "";
        for(int i=0;i<n;i++)
            t = s.charAt(i)+t;

        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j] = 0;
                else if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else 
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return n-dp[n][n];
    }
} 