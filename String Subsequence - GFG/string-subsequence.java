// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}// } Driver Code Ends
class Solution {
    int countWays(String S1, String S2) { 
         int[][] dp=new int[S2.length()+1][S1.length()+1];
       for(int i=0;i<=S2.length();i++)
       {
           for(int j=0;j<=S1.length();j++)
           {
               if(i==0)
             dp[i][j]=1;
             else if(j==0)
             dp[i][j]=0;
             else if(S2.charAt(i-1)==S1.charAt(j-1))
             dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
             else if(S2.charAt(i-1)!=S1.charAt(j-1))
             dp[i][j]=dp[i][j-1];
           }
       }
       return dp[S2.length()][S1.length()];
    }
}