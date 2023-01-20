class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;
        for(int i=0;i<weights.length;i++)
            high+=weights[i];
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;
    }
    public boolean isPossible(int arr[], int days,int minCapacity){
        int minDays = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(minCapacity<arr[i])
                return false;
            if(sum+arr[i]>minCapacity){
                sum = arr[i];
                minDays++;
            }else
                sum+=arr[i];
        }
        if(minDays<=days)
            return true;
        return false;
    }
}