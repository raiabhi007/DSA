class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxStraightSum = Integer.MIN_VALUE;
        int minStraightSum = Integer.MAX_VALUE;
        int arraySum = 0;
        
        int tempMaxSum = 0;
        int tempMinSum = 0;
        
        for(int i=0;i<nums.length;i++){
            arraySum+=nums[i];
            tempMaxSum+=nums[i];
            if(tempMaxSum>maxStraightSum)
                maxStraightSum = tempMaxSum;
            if(tempMaxSum<0)
                tempMaxSum = 0;
            
            tempMinSum+=nums[i];
            if(tempMinSum<minStraightSum)
                minStraightSum = tempMinSum;
            if(tempMinSum>0)
                tempMinSum = 0;
        }
        if(arraySum==minStraightSum)
            return maxStraightSum;
        return Math.max(maxStraightSum,arraySum-minStraightSum);
    }
}