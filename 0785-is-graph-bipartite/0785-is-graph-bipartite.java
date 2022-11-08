class Solution {
    public boolean check(int start,int V, ArrayList<ArrayList<Integer>> adj,int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int it:adj.get(node)){
                if(color[it]==-1){
                    color[it] = 1-color[node];
                    q.add(it);
                }else if(color[it]==color[node])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,V,adj,color)==false)
                    return false;
            }
        }
        return true;
    }
}