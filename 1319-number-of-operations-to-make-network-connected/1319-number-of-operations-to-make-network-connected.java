class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            for(int j=0;j<connections[i].length;j++){
                adj.get(connections[i][0]).add(connections[i][1]);
                adj.get(connections[i][1]).add(connections[i][0]);
            }
        }
        boolean[] visited = new boolean[n];
        int connectedComponents = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(adj,visited,i);
                connectedComponents++;
            }
        }
        return connectedComponents-1;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int i){
          visited[i] = true;
         for(int j:adj.get(i)){
             if(visited[j]==false)
                 dfs(adj,visited,j);
         }
    }
}