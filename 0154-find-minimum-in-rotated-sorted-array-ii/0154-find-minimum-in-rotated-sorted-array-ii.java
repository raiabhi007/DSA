class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid>0&&arr[mid]<arr[mid-1])
            return arr[mid];
            else if(mid<n-1&&arr[mid]>arr[mid+1])
            return arr[mid+1];
            else if(arr[low]>arr[mid])
            high = mid-1;
            else if(arr[high]<arr[mid])
            low = mid+1;
            else
            high--;    
        }
        return arr[0];
    }
}