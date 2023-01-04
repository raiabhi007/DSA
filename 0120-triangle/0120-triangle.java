class Solution {
    public int minimumTotal(List<List<Integer>> triangle){
        
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i=0;i<triangle.size();i++)
            Arrays.fill(dp[i],-1);
        int ans = helper(0,0,triangle,dp);
        return ans;
    }
    int helper(int i,int j,List<List<Integer>>triangle,int[][] dp){
        if(i>=triangle.size())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int first = helper(i+1,j,triangle,dp);
        int second = helper(i+1,j+1,triangle,dp);
        
        return dp[i][j]=triangle.get(i).get(j) + Math.min(first,second);
        
    }
}