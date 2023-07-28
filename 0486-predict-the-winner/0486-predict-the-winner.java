class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        
        int sum = 0;
        for(int num : nums) sum+=num;
        
        int[][] dp = new int[length][length];
        
        for(int j = 0 ; j< length ; j++)
        {
            int curSum = 0;
            for(int i = j ; i>= 0 ; i--)
            {
                curSum+=nums[i];
                if(i == j) dp[i][j]=nums[j];
                else
                {
                    dp[i][j]=Math.max(curSum-dp[i][j-1], curSum-dp[i+1][j]);
                }
            }
        }
        return dp[0][length-1]*2>=sum;
    }
}