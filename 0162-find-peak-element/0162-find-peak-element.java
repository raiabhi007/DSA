class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((mid==0||arr[mid-1]<=arr[mid])&&(mid==n-1||arr[mid]>=arr[mid+1]))
                return mid;
            else if(mid>0&&arr[mid-1]>=arr[mid])
                high = mid;
            else
                low = mid+1;
        }
        return -1;
    }
}