class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0]==1)
                dfs(grid,i,0,vis);
            if(grid[i][m-1]==1)
                dfs(grid,i,m-1,vis);
        }
        
         for(int j=0;j<m;j++){
            if(grid[0][j]==1)
                dfs(grid,0,j,vis);
            if(grid[n-1][j]==1)
                dfs(grid,n-1,j,vis);
        }
        int ans = 0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==1&&vis[i][j]==false)
                    ans++;
            }
        }
        return ans;
    }
    void dfs(int[][] grid,int i,int j,boolean[][] vis){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||vis[i][j]==true){
            return;
        }
        
        vis[i][j]=true;
        dfs(grid,i-1,j,vis);
        dfs(grid,i,j-1,vis);
        dfs(grid,i+1,j,vis);
        dfs(grid,i,j+1,vis);
        
    }
}