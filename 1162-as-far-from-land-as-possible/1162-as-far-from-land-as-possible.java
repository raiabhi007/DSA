public class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {  
    public int maxDistance(int[][] grid) {      
        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    q.add(new Pair(i,j));
            }
        }
        if(q.size()==0||q.size()==grid.length*grid[0].length)
            return -1;
        
        int level = -1;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            level+=1;
            while(size-->0){
                Pair rem = q.poll();
                for(int i=0;i<4;i++){
                    int rowDash = rem.row + dir[i][0];
                    int colDash = rem.col + dir[i][1];
                    if(rowDash<0||rowDash>=grid.length||colDash<0||colDash>=grid[0].length||grid[rowDash][colDash]==1)
                        continue;
                    q.add(new Pair(rowDash,colDash));
                    grid[rowDash][colDash] = 1;
                }
            }
        }
        return level;
    }
}