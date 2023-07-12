class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;
        for(int i=0;i<weights.length;i++)
            high+=weights[i];
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(weights,mid,days)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] weights,int mid,int days){
        int tempWeight = 0;
        int totalDays = 1;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>mid)
                return false;
            tempWeight+=weights[i];
            if(tempWeight>mid){
                tempWeight = weights[i];
                totalDays++;
            }
        }
        return totalDays<=days;
    }
}