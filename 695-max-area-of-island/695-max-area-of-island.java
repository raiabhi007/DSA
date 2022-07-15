class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j]==false){
                    int temp = areaOfIsland(grid,i,j,visited);
                    ans = Math.max(ans,temp);    
                }
            }
        }
        return ans;
    }
    public int areaOfIsland(int[][] grid,int i,int j,boolean visited[][]){
        if(i>=grid.length||j>=grid[0].length||i<0||j<0||grid[i][j]==0||visited[i][j]==true)
            return 0;
        visited[i][j] = true;
        int left = areaOfIsland(grid,i,j+1,visited);
        int right = areaOfIsland(grid,i,j-1,visited);
        int bottom = areaOfIsland(grid,i+1,j,visited);
        int top = areaOfIsland(grid,i-1,j,visited);
        return 1+left+right+bottom+top;
    } 
}