class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] memo = new double[102][102];
        memo[0][0] = poured;
        for(int i=0;i<=query_row;i++){
            for(int j=0;j<=i;j++){
                if(memo[i][j]>1){
                    double extra = memo[i][j]-1;
                    memo[i][j] = 1;
                    memo[i+1][j]+=extra/2;
                    memo[i+1][j+1]+=extra/2;
                }
            }
        }
        return memo[query_row][query_glass];
    }
}