class Solution {
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0&&visited[i][j]==false){
                    boolean temp = dfs(grid,visited,i,j);
                    if(temp) ans++;
                }
            }
        }
        return ans;
    }
    public boolean dfs(int[][] grid,boolean[][] visited,int i,int j){
        if(i<0||j<0||i==grid.length||j==grid[0].length)
            return true;
        
        if((i==0||j==0||i==grid.length-1||j==grid[0].length-1)&&grid[i][j]==0)
            return false;                        
        if(visited[i][j]==true||grid[i][j]==1)
            return true;
        visited[i][j] = true;
        boolean top = dfs(grid,visited,i-1,j);
        boolean left = dfs(grid,visited,i,j-1);
        boolean bottom = dfs(grid,visited,i+1,j);
        boolean right = dfs(grid,visited,i,j+1);
        
        return (top&&bottom&&right&&left);
    }
}