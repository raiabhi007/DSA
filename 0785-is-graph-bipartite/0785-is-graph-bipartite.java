class Solution {
    public boolean check(int start,int prevColor, ArrayList<ArrayList<Integer>> adj,int color[]){
        color[start] = 1-prevColor;
        for(int it:adj.get(start)){
            if(color[it]==-1){
                if(check(it,color[start],adj,color)==false)
                    return false;
            }else if(color[it]==color[start])
                return false;
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
                if(check(i,1,adj,color)==false)
                    return false;
            }
        }
        return true;
    }
}