class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                arr[i][j] = board[i][j];
        }
        solve(arr,0,0,board);
    }
    public void solve(char[][] arr,int i,int j,char[][] board){
        if(i==arr.length){
             for(int row=0;row<9;row++){
            for(int col=0;col<9;col++)
                board[row][col] = arr[row][col];
            }
            return;
        }
        int ni = 0;
        int nj = 0;
        if(j==arr.length-1){
            ni = i+1;
            nj=0;
        }else{
            ni = i;
            nj = j+1;
        }
        if(arr[i][j]!='.'){
            solve(arr,ni,nj,board);
        }else{
            for(int po=1;po<=9;po++){
                char ch = (char)(po+'0');
                if(isValid(arr,i,j,ch)){
                arr[i][j] = ch;
                solve(arr,ni,nj,board);
                arr[i][j] = '.';
                }
            }
        }
    }
    public boolean isValid(char[][] board,int x,int y,char val){
        for(int j=0;j<board[0].length;j++){
            if(board[x][j]==val)
                return false;
        }
        for(int i=0;i<board.length;i++){
            if(board[i][y]==val)
                return false;
        }
        int smi = (x/3)*3;
        int smj = (y/3)*3;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[smi+i][smj+j]==val)
                    return false;
            }
        }
        return true;
    }
}