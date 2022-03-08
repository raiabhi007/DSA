class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        int ans = 0;
        for(int i=0;i<isConnected.length;i++){
                if(visited[i]==false){
                    dfs(isConnected,visited,i);
                    ans++;
           }            
        }
        return ans;
    }
    public void dfs(int[][] isConnected,boolean[] visited,int i){
        int n = isConnected.length;
        visited[i] = true;
        
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1&&visited[j]==false)
                dfs(isConnected,visited,j);
        }
    }
}