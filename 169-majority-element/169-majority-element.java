class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==element)
                count++;
            else
                count--;
            if(count==0){
                element = nums[i];
                count = 1;
            }
        }
        return element;
    }
}