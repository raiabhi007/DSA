class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0;i<n;i++){
            if(board[i][0]=='O')
                dfs(board,i,0,vis);
            if(board[i][m-1]=='O')
                dfs(board,i,m-1,vis);
        }
         for(int j=0;j<m;j++){
            if(board[0][j]=='O')
                dfs(board,0,j,vis);
            if(board[n-1][j]=='O')
                dfs(board,n-1,j,vis);
        }
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(vis[i][j]==false&&board[i][j]=='O')
                    board[i][j] = 'X';
            }
        }
        
    }
    void dfs(char[][] board, int i, int j,boolean[][] vis){
        if(i<0||i>=vis.length||j<0||j>=vis[0].length||board[i][j]=='X'||vis[i][j]==true)
            return;
        vis[i][j] = true;
        dfs(board,i-1,j,vis);
        dfs(board,i,j-1,vis);
        dfs(board,i+1,j,vis);
        dfs(board,i,j+1,vis);
    }
    
}