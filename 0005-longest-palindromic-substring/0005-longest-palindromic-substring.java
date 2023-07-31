class Solution {
    public String longestPalindrome(String s) {
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
                    if(j-i>right-left&&dp[i][j]==true){
                         left=i;
                         right=j;
                    }
                }
            }
        }
        return s.substring(left,right+1);
    }
}