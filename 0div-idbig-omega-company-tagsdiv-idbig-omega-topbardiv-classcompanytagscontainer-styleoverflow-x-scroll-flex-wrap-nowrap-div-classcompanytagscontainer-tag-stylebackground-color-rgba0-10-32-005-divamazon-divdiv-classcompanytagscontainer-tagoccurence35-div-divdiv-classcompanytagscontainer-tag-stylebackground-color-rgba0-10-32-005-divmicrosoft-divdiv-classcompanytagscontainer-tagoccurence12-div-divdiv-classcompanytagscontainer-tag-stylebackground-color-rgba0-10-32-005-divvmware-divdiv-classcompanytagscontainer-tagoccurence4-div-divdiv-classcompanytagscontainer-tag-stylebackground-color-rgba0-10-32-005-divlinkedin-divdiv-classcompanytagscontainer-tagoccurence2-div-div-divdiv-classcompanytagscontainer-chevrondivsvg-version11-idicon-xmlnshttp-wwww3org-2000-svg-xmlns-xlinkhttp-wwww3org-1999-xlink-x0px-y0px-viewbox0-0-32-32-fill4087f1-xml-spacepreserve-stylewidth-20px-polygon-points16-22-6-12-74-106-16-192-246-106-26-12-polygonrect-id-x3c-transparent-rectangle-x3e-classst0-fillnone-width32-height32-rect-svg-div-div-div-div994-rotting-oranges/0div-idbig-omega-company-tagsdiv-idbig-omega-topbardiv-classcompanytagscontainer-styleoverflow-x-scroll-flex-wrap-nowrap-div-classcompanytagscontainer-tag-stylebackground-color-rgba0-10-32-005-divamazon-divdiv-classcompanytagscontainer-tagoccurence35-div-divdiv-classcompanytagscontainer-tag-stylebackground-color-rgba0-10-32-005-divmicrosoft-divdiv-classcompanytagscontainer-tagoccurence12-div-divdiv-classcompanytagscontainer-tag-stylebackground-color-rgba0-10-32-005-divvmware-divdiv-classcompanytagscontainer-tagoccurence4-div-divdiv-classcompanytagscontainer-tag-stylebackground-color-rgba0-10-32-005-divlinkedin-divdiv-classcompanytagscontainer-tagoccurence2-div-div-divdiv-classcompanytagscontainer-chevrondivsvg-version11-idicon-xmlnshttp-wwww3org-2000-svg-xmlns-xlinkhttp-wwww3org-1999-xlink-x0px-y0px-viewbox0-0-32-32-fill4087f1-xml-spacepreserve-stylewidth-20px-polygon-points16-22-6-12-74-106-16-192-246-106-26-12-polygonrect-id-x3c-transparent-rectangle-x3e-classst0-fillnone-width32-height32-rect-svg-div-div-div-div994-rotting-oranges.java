class Tuple{
    int r;
    int c;
    int t;
    public Tuple(int r,int c,int t){
        this.r = r;
        this.c = c;
        this.t = t;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int row[] = {0,-1,0,1};
        int col[] = {-1,0,1,0};
        int count = 0;
        int time = -1;
        Queue<Tuple> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) q.add(new Tuple(i,j,0));
                if(grid[i][j]==1) count++;
            }
        }
        int cnt = 0;
        if(count==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            while(size-->0){
                Tuple cur = q.poll();

                for(int i=0;i<4;i++){
                    int nr = cur.r+row[i];
                    int nc = cur.c+col[i];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1){
                        grid[nr][nc] = 0;
                        q.add(new Tuple(nr,nc,time));
                        cnt++;
                    }
                }
            }
        }
        if(count==cnt)
        return time;
        return -1;
    }
}