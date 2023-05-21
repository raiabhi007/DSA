public class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int shortestBridge(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,visited,q);
                    break;
                }
            }
            if(!q.isEmpty())
                break;
        }
        int level = -1;
         while(!q.isEmpty()){
            int size = q.size();
            level+=1;
            while(size-->0){
                Pair rem = q.poll();
                for(int i=0;i<4;i++){
                    int rowDash = rem.row + dir[i][0];
                    int colDash = rem.col + dir[i][1];                
                    if(rowDash<0||rowDash>=grid.length||colDash<0||colDash>=grid[0].length)
                        continue;
                    
                    if(visited[rowDash][colDash]==false&&grid[rowDash][colDash]==1)
                        return level;
                    else if(visited[rowDash][colDash]==true&&grid[rowDash][colDash]==1)
                        continue;
                    grid[rowDash][colDash] = 1;
                    q.add(new Pair(rowDash,colDash));
                    visited[rowDash][colDash] = true;
                }
            }
        }
        return level;
    }
    public void dfs(int[][] grid,int i,int j,boolean[][] visited,Queue<Pair> q){
        if(i>=0&&j>=0&&i<grid.length&&j<grid[0].length&&visited[i][j]==false&&grid[i][j]==1){
            q.add(new Pair(i,j));
            visited[i][j] = true;
             dfs(grid,i-1,j,visited,q);
             dfs(grid,i,j-1,visited,q);
             dfs(grid,i+1,j,visited,q);
             dfs(grid,i,j+1,visited,q);
        }
    }
}