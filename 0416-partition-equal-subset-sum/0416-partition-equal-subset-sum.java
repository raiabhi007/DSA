class Solution {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        if(sum%2==1)
            return false;
        int partitionedSum = sum/2;
         boolean dp[][] = new boolean[n+1][partitionedSum+1];
        for(int i=0;i<n;i++)
        dp[i][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=partitionedSum;j++){
                if(j>=arr[i-1]){
                    boolean inc = dp[i-1][j-arr[i-1]];
                    boolean exc = dp[i-1][j];
                    dp[i][j] = exc||inc;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][partitionedSum];
    }
}