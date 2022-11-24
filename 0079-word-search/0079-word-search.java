class Solution {
    public boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(visited[i][j]==false&&board[i][j]==word.charAt(0)){
                    if(backtrack(i,j,0,board,word,visited))
                        return true;
                }
            }
        }
        return false;
        
    }
    public boolean backtrack(int i,int j,int idx,char[][] board,String word,boolean[][] visited){
        if(i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]==true)
            return false;
        if(word.charAt(idx)!=board[i][j])
            return false;
        
        if(idx+1==word.length())
            return true;
        
        visited[i][j] = true;
        boolean left = backtrack(i,j+1,idx+1,board,word,visited);
        boolean right = backtrack(i,j-1,idx+1,board,word,visited);
        boolean up = backtrack(i-1,j,idx+1,board,word,visited);
        boolean down = backtrack(i+1,j,idx+1,board,word,visited);
        
        visited[i][j] = false;
        return left||right||up||down;
    }
}