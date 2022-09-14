class Solution {
    public int maxProfit(int[] arr) {
        int ans = 0;
        int buy = arr[0];
        for(int i=1;i<arr.length;i++){
            ans = Math.max(ans,arr[i]-buy);
            if(buy>arr[i])
                buy = arr[i];
        }
        return ans;
    }
}