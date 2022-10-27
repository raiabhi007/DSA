class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = firstOccurence(nums,target);
        ans[1] = lastOccurence(nums,target);
        return ans;
    }
    public int firstOccurence(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                ans = mid;
                high = mid-1;
            }else if(arr[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return ans;
    }
     public int lastOccurence(int arr[],int target){
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==target){
                ans = mid;
                low = mid+1;
            }else if(arr[mid]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        return ans;
    }
}