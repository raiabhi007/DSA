class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cur = 1;
        for(int i=0;i<nums.length;i++){
            cur*=nums[i];
            ans = Math.max(cur,ans);
            if(cur==0)
                cur = 1;
        }
        cur = 1;
        for(int i=nums.length-1;i>=0;i--){
            cur*=nums[i];
            ans = Math.max(cur,ans);
            if(cur==0)
                cur = 1;
        }
        return ans;
    }
}