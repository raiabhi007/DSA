class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=1;i<=amount;i++){
            int temp = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i&&dp[i-coins[j]]!=Integer.MAX_VALUE)
                    temp = Math.min(temp,dp[i-coins[j]]+1);
            }
            dp[i] = temp;
        }
        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }
}