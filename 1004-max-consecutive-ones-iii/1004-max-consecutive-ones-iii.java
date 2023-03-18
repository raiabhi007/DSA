class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int count = 0;
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]==0){
                count++;
            }
            while(count>k){
                if(nums[i]==0) count--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}