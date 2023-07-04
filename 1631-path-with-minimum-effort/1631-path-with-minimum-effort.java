class Tuple{
    int row;
    int col;
    int diff;
  public Tuple(int row,int col,int diff){
      this.row = row;
      this.col = col;
      this.diff = diff;
      
  }  
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->(a.diff-b.diff));
        pq.add(new Tuple(0,0,0));
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(vis[i],(int)1e9);
        
        int rowdir[] = {-1,0,1,0};
        int coldir[] = {0,-1,0,1};
        
        vis[0][0] = 0;
        int ans = 0;
        while(!pq.isEmpty()){
            Tuple cur = pq.remove();
            int r = cur.row;
            int c = cur.col;
            int diff = cur.diff;
            if(r==n-1&&c==m-1)
                return vis[r][c];
            
            for(int i=0;i<4;i++){
                int nr = r+rowdir[i];
                int nc = c+coldir[i];
                if(nr<0||nr>=n||nc<0||nc>=m)
                    continue;
                int d = Math.abs(heights[nr][nc]-heights[r][c]);
                int newEffort = Math.max(d,diff);
                if(newEffort<vis[nr][nc]){
                    vis[nr][nc] = newEffort;
                    pq.add(new Tuple(nr,nc,vis[nr][nc]));
                }
            }
        }
        return vis[n-1][m-1];
    }
}