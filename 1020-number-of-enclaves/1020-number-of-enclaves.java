class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int ans = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==0||visited[i][j]==-1){
                    int temp = dfs(grid,visited,i,j);
                        if(temp!=-1)
                            ans+=temp;
                }
            }
        }
        return ans;
     }
    public int dfs(int[][] grid,int[][] visited,int i,int j){
        if(i<0||j<0||i==grid.length||j==grid[0].length||visited[i][j]==1||grid[i][j]==0)
            return 0;
        if(visited[i][j]==-1)
            return -1;
        
        if((i==0||j==0||i==grid.length-1||j==grid[0].length-1)&&grid[i][j]==1){
            visited[i][j] = -1;
            return -1;
        }
         visited[i][j] = 1;
         int left = dfs(grid,visited,i,j-1);
         int right = dfs(grid,visited,i,j+1);
         int top = dfs(grid,visited,i-1,j);
         int bottom = dfs(grid,visited,i+1,j);
         if(left==-1||right==-1||top==-1||bottom==-1){
             visited[i][j] = -1;
             return -1;
         }
       
         return 1+top+bottom+left+right;
            
    }
}