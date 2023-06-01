public class Pair{   
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    int[][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1)
            return -1;
        int level = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
             level+=1;
             int size = q.size();
            while(size-->0){
                Pair rem = q.poll();
                if(rem.row==n-1&&rem.col==n-1)
                    return level;
                for(int i=0;i<8;i++){
                    int rowDash = rem.row + dir[i][0];
                    int colDash = rem.col + dir[i][1];
                    if(rowDash<0||rowDash>=n||colDash<0||colDash>=n||grid[rowDash][colDash]==1)
                        continue;
                    q.add(new Pair(rowDash,colDash));
                    grid[rowDash][colDash] = 1;
                }
            }
        }
        return -1;
    }
}