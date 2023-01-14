class Solution {
    public int minCost(int n, int[] cut) {
        int cuts[] = new int[cut.length+2];
        int i=0;
        for(i=0;i<cut.length;i++){
            cuts[i] = cut[i];
        }
        cuts[i++] = 0;
        cuts[i] = n;
        Arrays.sort(cuts);
        int dp[][] = new int[cuts.length][cuts.length];
        for(i=0;i<cuts.length;i++){
          Arrays.fill(dp[i],-1);
        }
        return helper(1,cut.length,cuts,dp);
    }
    public int helper(int i,int j,int[] cuts,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int cost = cuts[j+1]-cuts[i-1] + helper(i,ind-1,cuts,dp)+helper(ind+1,j,cuts,dp);
            mini = Math.min(cost,mini);
        }
        return dp[i][j]=mini;
    }
}