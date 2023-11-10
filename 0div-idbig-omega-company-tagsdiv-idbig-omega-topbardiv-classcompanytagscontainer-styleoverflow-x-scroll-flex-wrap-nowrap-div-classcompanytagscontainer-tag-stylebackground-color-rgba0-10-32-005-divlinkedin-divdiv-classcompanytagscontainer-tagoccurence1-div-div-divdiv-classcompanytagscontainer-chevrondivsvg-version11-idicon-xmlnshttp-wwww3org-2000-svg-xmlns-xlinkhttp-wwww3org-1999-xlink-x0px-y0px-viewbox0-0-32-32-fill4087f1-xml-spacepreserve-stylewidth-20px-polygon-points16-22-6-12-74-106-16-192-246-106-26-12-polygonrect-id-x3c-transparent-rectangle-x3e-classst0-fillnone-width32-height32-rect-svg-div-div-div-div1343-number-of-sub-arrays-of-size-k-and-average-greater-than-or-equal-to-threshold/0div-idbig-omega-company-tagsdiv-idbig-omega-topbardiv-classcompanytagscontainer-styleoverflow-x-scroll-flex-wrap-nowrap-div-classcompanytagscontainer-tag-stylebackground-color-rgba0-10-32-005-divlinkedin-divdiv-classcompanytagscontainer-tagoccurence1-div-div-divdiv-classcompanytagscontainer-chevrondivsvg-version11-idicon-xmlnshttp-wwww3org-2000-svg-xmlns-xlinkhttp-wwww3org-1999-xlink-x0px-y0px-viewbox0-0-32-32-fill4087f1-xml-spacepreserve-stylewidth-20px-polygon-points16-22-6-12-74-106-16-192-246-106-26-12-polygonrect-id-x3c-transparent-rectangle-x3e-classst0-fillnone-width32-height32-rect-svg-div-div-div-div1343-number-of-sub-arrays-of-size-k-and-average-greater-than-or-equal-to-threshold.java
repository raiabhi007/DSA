class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int ans= 0;
        for(int i=0;i<arr.length;i++){
            if(i<k){
                sum+=arr[i];
            }else{
                sum+=arr[i];
                sum-=arr[i-k];
            }
            if(i>=k-1&&(sum/k)>=threshold){
                ans++;
            }
        }
        return ans;
    }
}