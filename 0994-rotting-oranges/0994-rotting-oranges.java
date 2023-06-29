class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.add(new Pair(i,j,0));
                if(grid[i][j]==1)
                    count++;
            }
        }
        int time = 0;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
      
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            time = Math.max(t,time);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    grid[nrow][ncol] = 2;
                    count--;
                }
            }
        }
        if(count==0)
            return time;
        return -1;
    }
}