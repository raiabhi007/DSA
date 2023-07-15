class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int a = nums[0];
        int b = Math.max(nums[1],nums[0]);
        
        for(int i=2;i<nums.length;i++){
            int c = Math.max(b,nums[i]+a);
            a = b;
            b = c;
        }
        return b;
    }
}