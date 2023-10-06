class Solution {
    public int integerBreak(int n) {
        if(n==2||n==3)
            return n-1;
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4;i<=n;i++){
            int temp = Integer.MIN_VALUE;
            for(int j=i-1;j>1;j--){
                temp = Math.max(temp,j*dp[i-j]);
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}