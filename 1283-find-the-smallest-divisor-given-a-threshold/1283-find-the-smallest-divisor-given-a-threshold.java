class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
            high = Math.max(high,nums[i]);
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(nums,mid,threshold)){
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;
    }
    
    boolean isPossible(int nums[],int mid,int threshold){
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            temp = temp+nums[i]/mid;
            if(nums[i]%mid!=0)
                temp++;
        }
        return threshold>=temp;
    }
}