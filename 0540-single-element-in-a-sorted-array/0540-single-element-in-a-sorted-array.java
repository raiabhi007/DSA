class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((mid==0||arr[mid-1]!=arr[mid])&&(mid==n-1||arr[mid]!=arr[mid+1]))
                return arr[mid];
            else if((mid%2==1&&arr[mid]==arr[mid-1])||(mid%2==0&&arr[mid]==arr[mid+1]))
                low = mid+1;
            else
                high = mid-1;
        }
        return arr[0];
    }
}