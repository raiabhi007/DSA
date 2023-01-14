class Solution {
    public int minCost(int n, int[] cut) {
        int c = cut.length;
        int cuts[] = new int[c+2];
        int i=0;
        for(i=0;i<c;i++){
            cuts[i] = cut[i];
        }
        cuts[i++] = 0;
        cuts[i] = n;
        Arrays.sort(cuts);
        int dp[][] = new int[c+2][c+2];
        for(i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost = cuts[j+1]-cuts[i-1] + dp[i][ind-1]+dp[ind+1][j];
                    mini = Math.min(mini,cost);
                }
                dp[i][j] = mini;
            }
        }
        
        return dp[1][c];
    }
    
//     public int helper(int i,int j,int[] cuts,int[][] dp){
//         if(i>j) return 0;
//         if(dp[i][j]!=-1)
//             return dp[i][j];
//         int mini = Integer.MAX_VALUE;
//         for(int ind=i;ind<=j;ind++){
//             int cost = cuts[j+1]-cuts[i-1] + helper(i,ind-1,cuts,dp)+helper(ind+1,j,cuts,dp);
//             mini = Math.min(cost,mini);
//         }
//         return dp[i][j]=mini;
//     }    
 }