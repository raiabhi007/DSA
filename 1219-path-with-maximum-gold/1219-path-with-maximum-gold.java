class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int ans[] = new int[1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)
                backtrack(grid,i,j,vis,ans);
            }
        }
        return ans[0];
    }
    public int backtrack(int[][] grid,int i,int j,boolean[][] vis,int[] ans){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||vis[i][j]==true)
            return 0;
        vis[i][j] = true;
        int ls = backtrack(grid,i,j-1,vis,ans);
        int rs = backtrack(grid,i,j+1,vis,ans);
        int us = backtrack(grid,i-1,j,vis,ans);
        int ds = backtrack(grid,i+1,j,vis,ans);
        vis[i][j] = false;
        int maxi = grid[i][j]+Math.max(ls,Math.max(rs,Math.max(us,ds)));
        ans[0] = Math.max(ans[0],maxi);
        return maxi;
    }
}