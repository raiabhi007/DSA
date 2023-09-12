class Solution {
    public int maxSizeSlices(int[] slices) {
        int numOfSlices = slices.length/3;
        int dp[][] = new int[slices.length][numOfSlices+1];
        for(int i=0;i<slices.length;i++)
            Arrays.fill(dp[i],-1);
        
        int one=helper(0,slices.length-1,numOfSlices,slices,dp);
        for(int i=0;i<slices.length;i++)
            Arrays.fill(dp[i],-1);
        int two=helper(1,slices.length,numOfSlices,slices,dp);
        return Math.max(one,two);
    }
    public int helper(int i,int len,int numOfSlices,int slices[],int[][] dp){
        if(i>=len) return 0;
        if(numOfSlices==0) return 0;
        if(dp[i][numOfSlices]!=-1) return dp[i][numOfSlices];
        
        int inc = slices[i]+helper(i+2,len,numOfSlices-1,slices,dp);
        int exc = helper(i+1,len,numOfSlices,slices,dp);
        return dp[i][numOfSlices]=Math.max(inc,exc);
    }
}