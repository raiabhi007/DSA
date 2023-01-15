//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int mod = 1003;
    static int helper(int i,int j,int isTrue,String exp,int dp[][][]){
        if(i>j) return 0;
        if(i==j){
            if(isTrue==1)
            return exp.charAt(i)=='T'?1:0;
            else
            return exp.charAt(i)=='F'?1:0;
        }
        if(dp[i][j][isTrue]!=-1)
        return dp[i][j][isTrue];
        int ways = 0;
        for(int ind=i+1;ind<=j-1;ind+=2){
            int lT = helper(i,ind-1,1,exp,dp)%mod;
            int lF = helper(i,ind-1,0,exp,dp)%mod;
            int rT = helper(ind+1,j,1,exp,dp)%mod;
            int rF = helper(ind+1,j,0,exp,dp)%mod;
            
            if(exp.charAt(ind)=='&'){
                if(isTrue==1)
                ways = (ways+(rT*lT)%mod)%mod;
                else
                ways = (ways+(rT*lF)%mod+(rF*lT)%mod+(rF*lF)%mod)%mod;
            }else if(exp.charAt(ind)=='|'){
                if(isTrue==1)
                ways = (ways+(lT*rT)%mod+(lT*rF)%mod+(lF*rT)%mod)%mod;
                else
                ways = (ways+(rF*lF)%mod)%mod;
            }else{
                if(isTrue==1)
                ways = (ways+(lT*rF)%mod+(lF*rT)%mod)%mod;
                else
                ways = (ways+(lT*rT)%mod+(lF*rF)%mod)%mod;
            }
        }
        return dp[i][j][isTrue]=ways;
    }
    static int countWays(int N, String S){
        int dp[][][] = new int[N][N][2];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        return helper(0,N-1,1,S,dp);
    }
}