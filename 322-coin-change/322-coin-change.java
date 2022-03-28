class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<=amount;i++){
            int ans = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]&&dp[i-coins[j]]!=Integer.MAX_VALUE){
                    int temp = 1+dp[i-coins[j]];
                    ans = Math.min(ans,temp);
                }
            }
            dp[i] = ans;
        }
        return (dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
    }
}