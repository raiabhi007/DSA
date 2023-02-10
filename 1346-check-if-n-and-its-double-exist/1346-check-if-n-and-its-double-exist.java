class Solution {
    public boolean checkIfExist(int[] arr) {
         Arrays.sort(arr);
        for(int i=0;i<arr.length;i++) {
            int x=arr[i]*2;
            int l=0;
            int r=arr.length-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(mid!=i && arr[mid]==x){
                    return true;
                }
                else if(arr[mid]<x){
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }
            }
        }
        return false;
    }
}