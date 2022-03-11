class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] dfsVisited = new boolean[n];
        boolean[] cycleCheck = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visited[i]==false)
                dfs(graph,i,visited,dfsVisited,cycleCheck);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(cycleCheck[i]==false)
                ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int[][] graph,int src,boolean[] visited,boolean[] dfsVisited,boolean[] cycleCheck){
        visited[src] = true;
        dfsVisited[src] = true;
        
        for(int it:graph[src]){
            if(visited[it]==false){
                if(dfs(graph,it,visited,dfsVisited,cycleCheck))
                    return cycleCheck[src] = true;
            }
            else if(dfsVisited[it])
            return cycleCheck[src] = true;
        }
        dfsVisited[src] = false;
        return false;
    }
}