class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int ans = -1;
        int high = 0;
        for(int i=0;i<piles.length;i++)
           high = Math.max(piles[i],high);
        
        while(low<=high){
            int mid = low+(high-low)/2;
            int totalHours = calculateTotalHours(piles,mid);
            
            if(totalHours<=h){
                high = mid-1;
            }else
                low = mid+1;
        }
        return low;
    }
    public int calculateTotalHours(int[] v,int hourly){
       int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
}