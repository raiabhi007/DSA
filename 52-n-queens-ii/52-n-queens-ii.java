class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[2*n-1];
        boolean[] d2 = new boolean[2*n-1];
        nQueens(col,d1,d2,0);
        return ans;
    }
    public void nQueens(boolean[] col,boolean[] d1,boolean d2[],int i){
        int n = col.length;
        if(i==n){
            ans++;
            return;
        }
        for(int j=0;j<n;j++){
            if(col[j]==false&&d1[i+j]==false&&d2[i-j+n-1]==false){
                col[j] = true;
                d1[i+j] = true;
                d2[i-j+n-1] = true;
                nQueens(col,d1,d2,i+1);
                col[j] = false;
                d1[i+j] = false;
                d2[i-j+n-1] = false;
            }
        }   
    }
}