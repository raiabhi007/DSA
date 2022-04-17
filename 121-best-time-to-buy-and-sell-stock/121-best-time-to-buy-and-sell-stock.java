class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++){
            if(buy>prices[i])
                buy = prices[i];
            else{
                ans = Math.max(ans,prices[i]-buy);
            }
        }
        return ans;
    }
}