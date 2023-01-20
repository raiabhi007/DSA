class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int i=0;i<nums.length;i++){
            low = Math.min(low,nums[i]);
            high+=nums[i];
        }
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(nums,k,mid)){
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;
    }
    public boolean isPossible(int arr[], int k, int sum){
        int tempSum = 0;
        int tempK = 1;
        for(int i=0;i<arr.length;i++){
            if(sum<arr[i])
                return false;
            if(tempSum+arr[i]>sum){
                tempK++;
                tempSum = arr[i];
            }else
                tempSum+=arr[i];
        }
        if(tempK>k)
            return false;
        return true;
    }
}