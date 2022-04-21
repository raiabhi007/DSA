class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int ans1 = robHelper(nums,0,nums.length-2);
        int ans2 = robHelper(nums,1,nums.length-1);
        
        return Math.max(ans1,ans2);
    }
    public int robHelper(int[] nums,int i,int j){
        if(i==j)
            return nums[i];
         int prevNo = 0;
         int prevYes = 0; 
        for(int k=i;k<=j;k++){
            int temp = prevNo;
            prevNo = Math.max(prevNo,prevYes);
            prevYes = nums[k]+temp;
        }
        return Math.max(prevNo,prevYes);
    }
}