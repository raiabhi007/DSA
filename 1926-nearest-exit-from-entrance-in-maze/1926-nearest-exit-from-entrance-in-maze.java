public class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> q = new LinkedList<>();
        int n = maze.length;
        int m = maze[0].length;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        q.add(new Pair(entrance[0],entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';
        int level = 0;
        while(!q.isEmpty()){
            level+=1;
            int size = q.size();
            while(size-->0){
                Pair rem = q.poll();
                for(int i=0;i<4;i++){
                    int rowDash = rem.row + dir[i][0];
                    int colDash = rem.col + dir[i][1];
                if(rowDash<0||rowDash>=n||colDash<0||colDash>=m||maze[rowDash][colDash]=='+')
                    continue;
                if(rowDash==0||colDash==0||rowDash==n-1||colDash==m-1)
                    return level;
                    maze[rowDash][colDash] = '+';
                    q.add(new Pair(rowDash,colDash));
                }
            }
        }
        return -1;
    }
}