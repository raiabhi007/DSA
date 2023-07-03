class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col  = col;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1)
            return -1;
        int level=0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int row[] = {-1,0,1,0,-1,-1,1,1};
        int col[] = {0,-1,0,1,-1,1,-1,1};
        while(!q.isEmpty()){
            level+=1;
            int size = q.size();
            while(size-->0){
                int r = q.peek().row;
                int c = q.peek().col;
                if(r==n-1&&c==n-1)
                    return level;
                q.remove();
                for(int i=0;i<8;i++){
                    int nrow = r+row[i];
                    int ncol = c+col[i];
                    if(nrow<0||nrow>=n||ncol<0||ncol>=n||grid[nrow][ncol]==1)
                        continue;
                    q.add(new Pair(nrow,ncol));
                    grid[nrow][ncol] = 1;
                }
            }
        }
        return -1;
    }
}