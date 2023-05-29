//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[m.length][m[0].length];
        helper(m,0,0,"",ans,vis);
        return ans;
    }
    public static void helper(int[][] m,int i,int j,String S,ArrayList<String> ans, boolean vis[][]){
        if(i<0||i>=m.length||j<0||j>=m[0].length||vis[i][j]==true||m[i][j]==0)
        return;
        if(i==m.length-1&&j==m[0].length-1){
            ans.add(S);
            return;
        }
        vis[i][j] = true;
        helper(m,i+1,j,S+'D',ans,vis);
        helper(m,i-1,j,S+'U',ans,vis);
        helper(m,i,j+1,S+'R',ans,vis);
        helper(m,i,j-1,S+'L',ans,vis);
        vis[i][j] = false;
    }
}