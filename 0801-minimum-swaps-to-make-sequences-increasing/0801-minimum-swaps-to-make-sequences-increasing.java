class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int arr1[] = new int[n+1];
        int arr2[] = new int[n+1];
        arr1[0] = -1;
        arr2[0] = -1;
        for(int i=1;i<=n;i++){
            arr1[i] = nums1[i-1];
            arr2[i] = nums2[i-1];
        }
        int swapped = 0;
        int[][] dp = new int[n+2][2];
        for(int i=0;i<=n+1;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return helper(arr1,arr2,1,swapped,dp);
    }
    public int helper(int arr1[],int arr2[],int idx,int swapped,int[][] dp){
        if(idx==arr1.length) return 0;
        int prev1 = arr1[idx-1];
        int prev2 = arr2[idx-1];
        if(dp[idx][swapped]!=-1) return dp[idx][swapped];
        if(swapped==1){
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }
        int ans = Integer.MAX_VALUE;
        if(arr1[idx]>prev1&&arr2[idx]>prev2)
            ans = helper(arr1,arr2,idx+1,0,dp);
        
        if(arr1[idx]>prev2&&arr2[idx]>prev1)
            ans = Math.min(ans,1+helper(arr1,arr2,idx+1,1,dp));
        return dp[idx][swapped]=ans;
    }
}