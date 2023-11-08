class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2) return nums.length;
        int n = nums.length;
        boolean changed = false;
        int i=2;
        for(i=2;i<n;i++){
            if(nums[i]==nums[i-2])
                break;
        }
        int j=i+1;
        while(j<n){
            if(nums[j]!=nums[i-2]){
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}