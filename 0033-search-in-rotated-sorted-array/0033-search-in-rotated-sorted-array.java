class Solution {
    public int search(int[] arr, int target) {
        int low = 0;
        int n = arr.length;
        int high = arr.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<arr[high]){
               if(target>=arr[mid]&&target<=arr[high])
                   low = mid+1;
                else
                    high = mid-1;
            }else{
                if(target<=arr[mid]&&target>=arr[low]){
                    high = mid-1;
                }else
                    low = mid+1;
            }
        }
        return -1;
    }
}