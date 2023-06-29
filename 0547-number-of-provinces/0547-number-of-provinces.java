class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int ans = 0;
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==false){
                ans++;
                dfs(i,isConnected,vis);
            }
        }
        return ans;
    }
    void dfs(int i, int[][] isConnected, boolean[] vis){
        vis[i] = true;
        
        for(int j=0;j<isConnected.length;j++){
            if(vis[j]==false&&isConnected[i][j]==1)
                dfs(j,isConnected,vis);
        }
    }
}