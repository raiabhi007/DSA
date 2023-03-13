//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word){
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board,i,j,vis,0,word))
                return true;
            }
        }
        return false;
    }
    public boolean backtrack(char[][] board, int i, int j,boolean[][] vis,int idx, String word){
        if(idx==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]==true||board[i][j]!=word.charAt(idx))
        return false;
        vis[i][j] = true;
        if(backtrack(board,i-1,j,vis,idx+1,word))
        return true;
        if(backtrack(board,i,j+1,vis,idx+1,word))
        return true;
        if(backtrack(board,i+1,j,vis,idx+1,word))
        return true;
        if(backtrack(board,i,j-1,vis,idx+1,word))
        return true;
        vis[i][j] = false;
        return false;
    }
}