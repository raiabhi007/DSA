class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int temp_max = 0;
        int min_sum = Integer.MAX_VALUE;
        int temp_min = 0;
        int arr_sum = 0;
        
        for(int i=0;i<nums.length;i++){
            temp_max+=nums[i];
            max_sum = Math.max(temp_max,max_sum);
            if(temp_max<0)
                temp_max = 0;
            temp_min+=nums[i];
            min_sum = Math.min(min_sum,temp_min);
            if(temp_min>0)
                temp_min = 0;
            arr_sum+=nums[i];
        }
        if(arr_sum==min_sum)
            return max_sum;
        return Math.max(max_sum,arr_sum-min_sum);
    }
}