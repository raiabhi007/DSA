class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==false&&grid[i][j]=='1'){
                    dfs(grid,visited,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,boolean[][] visited,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||visited[i][j]==true||grid[i][j]=='0')
            return;
        visited[i][j] = true;
        dfs(grid,visited,i-1,j);
        dfs(grid,visited,i,j-1);
        dfs(grid,visited,i+1,j);
        dfs(grid,visited,i,j+1);
    }
}