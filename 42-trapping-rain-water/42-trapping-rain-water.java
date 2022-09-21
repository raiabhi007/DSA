class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxleft[] = new int[n];
        int maxright[] = new int[n];
        int[] minLR = new int[n];
        int max = height[0];
        for(int i=1;i<n;i++){
            maxleft[i] = max;
            max = Math.max(height[i],max);
        }
        max = height[n-1];
        for(int i=n-2;i>=0;i--){
            maxright[i] = max;
            max = Math.max(max,height[i]);
        }
        for(int i=0;i<n;i++)
            minLR[i] = Math.min(maxleft[i],maxright[i]);
        int answer[] = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            int water = minLR[i] - height[i];
            if(water<=0)
                answer[i] = 0;
            else
                answer[i] = water;
            ans+=answer[i];
        }
        return ans;
    }
}