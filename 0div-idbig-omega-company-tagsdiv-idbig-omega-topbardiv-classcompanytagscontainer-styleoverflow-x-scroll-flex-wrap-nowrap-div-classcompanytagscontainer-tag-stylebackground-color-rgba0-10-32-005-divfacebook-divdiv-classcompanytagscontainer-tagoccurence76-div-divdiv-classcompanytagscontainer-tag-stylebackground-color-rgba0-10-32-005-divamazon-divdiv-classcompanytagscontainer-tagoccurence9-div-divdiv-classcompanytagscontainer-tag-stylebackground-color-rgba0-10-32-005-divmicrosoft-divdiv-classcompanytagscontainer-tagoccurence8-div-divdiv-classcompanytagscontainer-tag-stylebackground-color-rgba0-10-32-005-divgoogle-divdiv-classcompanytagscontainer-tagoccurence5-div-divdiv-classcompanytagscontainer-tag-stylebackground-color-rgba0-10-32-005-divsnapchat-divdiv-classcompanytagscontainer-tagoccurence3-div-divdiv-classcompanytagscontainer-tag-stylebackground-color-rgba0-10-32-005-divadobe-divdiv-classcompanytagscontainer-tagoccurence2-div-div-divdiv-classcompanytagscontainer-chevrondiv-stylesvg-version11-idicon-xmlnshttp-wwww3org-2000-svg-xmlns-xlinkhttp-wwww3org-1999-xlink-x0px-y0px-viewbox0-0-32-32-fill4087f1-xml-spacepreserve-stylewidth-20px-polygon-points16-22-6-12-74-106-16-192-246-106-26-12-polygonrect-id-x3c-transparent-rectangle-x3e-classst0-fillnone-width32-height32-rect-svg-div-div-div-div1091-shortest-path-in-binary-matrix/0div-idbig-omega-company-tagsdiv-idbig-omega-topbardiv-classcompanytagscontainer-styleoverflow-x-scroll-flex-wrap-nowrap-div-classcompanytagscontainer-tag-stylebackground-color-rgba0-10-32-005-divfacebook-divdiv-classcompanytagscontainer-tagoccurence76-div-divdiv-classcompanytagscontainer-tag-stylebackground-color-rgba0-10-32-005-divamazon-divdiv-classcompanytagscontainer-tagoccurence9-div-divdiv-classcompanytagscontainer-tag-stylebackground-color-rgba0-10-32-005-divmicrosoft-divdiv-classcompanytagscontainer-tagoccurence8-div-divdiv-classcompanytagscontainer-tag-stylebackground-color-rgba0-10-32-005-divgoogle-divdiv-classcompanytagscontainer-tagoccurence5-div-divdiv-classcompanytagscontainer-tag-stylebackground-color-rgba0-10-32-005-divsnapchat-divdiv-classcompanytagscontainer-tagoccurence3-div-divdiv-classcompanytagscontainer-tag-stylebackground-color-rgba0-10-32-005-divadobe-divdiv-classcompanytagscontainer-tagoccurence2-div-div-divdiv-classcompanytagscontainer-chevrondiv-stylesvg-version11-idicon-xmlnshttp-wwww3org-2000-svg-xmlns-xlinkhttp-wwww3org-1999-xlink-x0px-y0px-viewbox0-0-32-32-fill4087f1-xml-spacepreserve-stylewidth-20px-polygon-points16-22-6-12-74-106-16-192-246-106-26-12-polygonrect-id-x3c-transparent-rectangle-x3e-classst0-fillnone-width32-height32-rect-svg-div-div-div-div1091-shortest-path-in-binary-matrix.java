class Tuple{
    int row;
    int col;
    int distance;
    public Tuple(int row,int col,int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1) return -1;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,1));
        int vis[][] = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(vis[i],2000);
        vis[0][0] = 1;
        int[] row = {0,-1,0,1,-1,-1,1,1};
        int[] col = {-1,0,1,0,-1,1,-1,1};
        
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int distance = q.peek().distance;
            q.poll();
            for(int i=0;i<8;i++){
                int nrow = r+row[i];
                int ncol = c+col[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<n&&grid[nrow][ncol]==0&&vis[r][c]+1<vis[nrow][ncol]){
                    vis[nrow][ncol] = vis[r][c]+1;
                    q.add(new Tuple(nrow,ncol,vis[nrow][ncol]));
                }
            }
        }
        if(vis[n-1][n-1]==2000) return -1;
        return vis[n-1][n-1];
    }
}