//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(int[][] grid,int i, int j,int vis[][], ArrayList<String> vec,int row0,int col0){
        vis[i][j] = 1;
        vec.add(toString(i-row0,j-col0));
        int n = grid.length;
        int m = grid[0].length;
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,-1,0,1};
        for(int k=0;k<4;k++){
            int nrow = i+delrow[k];
            int ncol = j+delcol[k];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]==1)
            dfs(grid,nrow,ncol,vis,vec,row0,col0);
        }
    }
    String toString(int row,int col){
        return Integer.toString(row)+" "+Integer.toString(col);
    }
    int countDistinctIslands(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int[][] vis = new int[n][m];
       HashSet<ArrayList<String>> set = new HashSet<>();
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(vis[i][j]==0&&grid[i][j]==1){
                   ArrayList<String> vec = new ArrayList<>();
                   dfs(grid,i,j,vis,vec,i,j);
                   set.add(vec);
               }
           }
       }
       return set.size();
    }
}
