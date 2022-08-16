class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = 0;
        int a  = 0;
        int b = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0)
                    n+=1;
                if(grid[i][j]==1){
                    a = i;
                    b = j;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = helper(grid,a,b,visited,n);
        return ans;
    }
    public int helper(int[][] grid,int i,int j,boolean[][] visited,int n){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||visited[i][j]==true||grid[i][j]==-1)
            return 0;
        
        if(grid[i][j]==2){
            if(n==-1)
                return 1;
            return 0;
        }
        visited[i][j] = true;
        int ans = 0;
        ans+=helper(grid,i+1,j,visited,n-1);
        ans+=helper(grid,i-1,j,visited,n-1);
        ans+=helper(grid,i,j+1,visited,n-1);
        ans+=helper(grid,i,j-1,visited,n-1);
        visited[i][j] = false;
        return ans;
    }
}