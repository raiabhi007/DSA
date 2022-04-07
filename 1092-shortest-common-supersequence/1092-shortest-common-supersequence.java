class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
          int m = str1.length();
          int n = str2.length();
          int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    dp[i][j] = 0;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }  
        }
        int i=m,j=n;
        String ans = "";
        while(i>0 && j>0) {
            if(dp[i][j] == dp[i-1][j]) {
                ans=str1.charAt(i-1)+ans;
                i--;
            } else if(dp[i][j] == dp[i][j-1]) {
                ans=str2.charAt(j-1)+ans;
                j--;
            } else {
                ans=str1.charAt(i-1)+ans;
                i--;
                j--;
            }
        }
       
         while(i>0){
            ans=str1.charAt(i-1)+ans;
            i--;
        }
         while(j>0){
            ans=str2.charAt(j-1)+ans;
            j--;
        }
        return ans;
    }
}