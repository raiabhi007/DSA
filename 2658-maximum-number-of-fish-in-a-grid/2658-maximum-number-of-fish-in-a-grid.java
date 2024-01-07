class Pair{
    int row;
    int col;
    public Pair(int r,int c){
        this.row = r;
        this.col = c;
    }
}

class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int ans = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0&&vis[i][j]==false){
                    int tempAns = helper(i,j,grid,vis);
                    ans = Math.max(ans,tempAns);
                }
            }
        }
        return ans;
    }
   public int helper(int i,int j,int[][] grid,boolean[][] vis){
       int[] rowDer = {0,-1,0,1};
       int[] colDer = {-1,0,1,0};
       int ans = 0;
       vis[i][j] = true;
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(i,j));
       while(!q.isEmpty()){
           int r = q.peek().row;
           int c = q.peek().col;
           q.poll();
           ans+=grid[r][c];
           for(int k=0;k<4;k++){
               int newRow = r+rowDer[k];
               int newCol = c+colDer[k];
               if(newRow>=0&&newRow<grid.length&&newCol>=0&&newCol<grid[0].length&&grid[newRow][newCol]>0&&vis[newRow][newCol]==false){
                   vis[newRow][newCol] = true;
                   q.add(new Pair(newRow,newCol));
               }
           }
       }
       return ans;
   }
}