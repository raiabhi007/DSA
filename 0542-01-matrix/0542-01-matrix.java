class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int level = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0)
                    q.add(new Pair(i,j));
            }
        }
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            while(size-->0){
                Pair rem = q.poll();
                for(int i=0;i<4;i++){
                    int rowDash = rem.row+ dir[i][0];
                    int colDash = rem.col+ dir[i][1];
                   if(rowDash<0||colDash<0||rowDash>=n||colDash>=m||mat[rowDash][colDash]==0)
                       continue;
                    q.add(new Pair(rowDash,colDash));
                    mat[rowDash][colDash] = 0;
                    ans[rowDash][colDash] = level;
                }
            }
        }
        return ans;
    }
}