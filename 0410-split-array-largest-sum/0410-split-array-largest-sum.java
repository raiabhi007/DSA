class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int i=0;i<nums.length;i++)
            high+=nums[i];
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            int count = 1;
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                if(sum>mid){
                    count++;
                    sum = nums[i];
                }
                if(nums[i]>mid){
                    count = k+1;
                    break;
                }
            }
            if(count<=k){
                high = mid-1;
                ans = mid;
            }else
                low = mid+1;
        }
        return ans;
    }
}