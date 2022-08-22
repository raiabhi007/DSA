class Solution {
    public int rob(int[] nums) {
         if( nums.length==1)
            return nums[0];
        int n = nums.length;
        if(n==2)
            return Math.max(nums[0],nums[1]);
        int a = helper(nums,0,n-2);
        int b = helper(nums,1,n-1);
        return Math.max(a,b);
    }
    int helper(int[] nums,int i,int j){
        int a = nums[i];
        int b = Math.max(nums[i],nums[i+1]);
        for(int k=i+2;k<=j;k++){
            int c = Math.max(a+nums[k],b);
            a = b;
            b = c;
        }
        return b;
    }
}