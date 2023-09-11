class Solution {
    public int minSideJumps(int[] obstacles) {
        int dp[][] = new int[4][obstacles.length];
        for(int i=0;i<4;i++)
            Arrays.fill(dp[i],-1);
        
        return helper(2,0,obstacles,dp);
    }
    public int helper(int i,int j,int obstacles[],int[][] dp){
        if(j==obstacles.length-1) return 0;
        if(obstacles[j]==i) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        if(i==1){
            if(obstacles[j+1]!=1)
                ans = helper(i,j+1,obstacles,dp);
            else{
                int side2 = helper(i+1,j,obstacles,dp);
                int side3 = helper(i+2,j,obstacles,dp);
                ans = 1+Math.min(side2,side3);
            }   
        }else if(i==2){
            if(obstacles[j+1]!=2)
                ans = helper(i,j+1,obstacles,dp);
            else{
                int side1 = helper(i-1,j,obstacles,dp);
                int side3 = helper(i+1,j,obstacles,dp);
                ans = 1+Math.min(side1,side3);
            }
        }else{
            if(obstacles[j+1]!=3)
                ans = helper(i,j+1,obstacles,dp);
            else{
                int side1 = helper(i-2,j,obstacles,dp);
                int side2 = helper(i-1,j,obstacles,dp);
                ans = 1+Math.min(side1,side2);
            }
        }
        return dp[i][j]=ans;
    }
}