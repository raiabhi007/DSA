class Solution {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0)
                    backtrack(grid,i,j,visited);
            }
        }
        return max;
    }
    public int backtrack(int[][] grid,int i,int j,boolean[][] visited){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||visited[i][j]==true)
            return 0;
        
        visited[i][j] = true;
        int tempMax = grid[i][j];
        int left = backtrack(grid,i,j-1,visited);
        tempMax = Math.max(left+grid[i][j],tempMax);
        int right = backtrack(grid,i,j+1,visited);
        tempMax =Math.max(right+grid[i][j],tempMax);
        int up = backtrack(grid,i-1,j,visited);
        tempMax = Math.max(up+grid[i][j],tempMax);
        int down = backtrack(grid,i+1,j,visited);
        tempMax =Math.max(down+grid[i][j],tempMax);
        visited[i][j] = false;
        max = Math.max(tempMax,max);
        return tempMax;
    }
}