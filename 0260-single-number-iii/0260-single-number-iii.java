class Solution {
    public int[] singleNumber(int[] nums) {
        int ans[] = new int[2];
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            temp = temp^nums[i];
        }
        int setBits = (temp& ~(temp-1));
        int x = 0;
        int y = 0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&setBits)>0){
                x = x^nums[i];
            }else
                y = y^nums[i];
        }
        ans[0] = x;
        ans[1] = y;
        return ans;
    }
}