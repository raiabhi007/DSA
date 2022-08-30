class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[] dpl = new int[n];
        int leastsf = arr[0];
        for(int i=1;i<n;i++){
            if(leastsf>arr[i])
                leastsf = arr[i];
            dpl[i] = Math.max(dpl[i-1],arr[i]-leastsf);
        }
        int max = arr[n-1];
        int[] dpr = new int[n];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>max)
                max = arr[i];
            dpr[i] = Math.max(dpr[i+1],max-arr[i]);
        }
        int ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(dpr[i]+dpl[i],ans);
        return ans;
    }
}