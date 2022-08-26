class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int cur = 0;
        for(int i=0;i<values.length;i++){
            ans = Math.max(ans,values[i]+cur);
            cur = Math.max(cur,values[i])-1;
        }
        return ans;
    }
}