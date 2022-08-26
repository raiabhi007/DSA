class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        int max = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>max){   
                max = prices[i];
            }else if(prices[i-1]>prices[i]){
               ans+=(max-min);
               max = prices[i];
               min = prices[i];
            }
        } 
        ans+=(max-min);
        return ans;
    }
}