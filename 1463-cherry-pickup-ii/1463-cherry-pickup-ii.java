class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
         for (int row1[][]: dp) {
      for (int row2[]: row1) {
        Arrays.fill(row2, -1);
      }
        }
        return helper(grid,0,0,grid[0].length-1,dp);
    }
        
    int helper(int[][] grid,int i,int j1,int j2,int[][][] dp){
        
        if(j1<0||j1>=grid[0].length||j2<0||j2>=grid[0].length)
            return Integer.MIN_VALUE;
        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];
            if(i==grid.length-1){
                if(j1==j2)
                    return dp[i][j1][j2]=grid[i][j1];
                else
                    return dp[i][j1][j2]=grid[i][j1]+grid[i][j2];
            }
        int maxi = Integer.MIN_VALUE;
        
        for(int d1=-1;d1<=1;d1++){
            int ans = Integer.MIN_VALUE;
            for(int d2=-1;d2<=1;d2++){
                if(j1==j2)
                    ans = grid[i][j1]+helper(grid,i+1,j1+d1,j2+d2,dp);
                else
                    ans = grid[i][j1]+grid[i][j2]+helper(grid,i+1,j1+d1,j2+d2,dp);
                maxi = Math.max(ans,maxi);
            }
        }
        return dp[i][j1][j2]=maxi;
    }
}