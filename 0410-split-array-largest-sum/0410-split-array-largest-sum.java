class Solution {
    public int splitArray(int[] nums, int k) {
        int low = -1;
        int high = 0;
        for(int i=0;i<nums.length;i++){
            high+=nums[i];
            low = Math.max(low,nums[i]);
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(nums,mid,k)){
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;
    }
    boolean isPossible(int[] arr,int mid,int k){
        int tempSum = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(tempSum+arr[i]>mid){
                count++;
                tempSum = arr[i];
            }else
                tempSum+=arr[i];
        }
        return count<k;
    }
}