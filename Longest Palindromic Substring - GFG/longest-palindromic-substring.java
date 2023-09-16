//{ Driver Code Starts
//Initial Template for Java

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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String s){
         int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int left=0;
        int right=0;
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j)
                    dp[i][j] = true;
                else if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1)
                        dp[i][j]=true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                    if(j-i>=right-left&&dp[i][j]==true){
                         left=i;
                         right=j;
                    }
                }
            }
        }
        return s.substring(left,right+1);
    }
}