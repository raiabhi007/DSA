class Solution {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int ans = 0;
        int zeroCount = 0;
        boolean flag = false;
        while(j<nums.length){
            if(zeroCount>1){
                if(nums[i]==0)
                    zeroCount--;
                i++;
            }else{
               
                if(nums[j]==0){
                    zeroCount++;
                    flag = true;
                }
                    
                j++;
                 ans = Math.max(ans,j-i-zeroCount);
            }
        }
        if(flag==false)
            return ans-1;
        return ans;
    }
}