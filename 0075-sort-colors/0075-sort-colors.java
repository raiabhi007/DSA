class Solution {
    public void sortColors(int[] nums) {
        int end = nums.length-1;
        int start = 0;
        int mid = 0;
        while(mid<=end){
            if(nums[mid]==0){
                int temp = nums[start];
                nums[start] = 0;
                nums[mid] = temp;
                start++;
                mid++;
                
            }else if(nums[mid]==2){
                int temp = nums[end];
                nums[end] = 2;
                nums[mid] = temp;
                end--;
            }else
                mid++;
        }
    }
}