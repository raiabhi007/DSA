class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        path.add(0);
        dfs(graph,0,res,path);
        return res;
    }
    private void dfs(int[][] graph,int src,List<List<Integer>> res,List<Integer> path){
        if(src==graph.length-1){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int nextSrc:graph[src]){
            path.add(nextSrc);
            dfs(graph,nextSrc,res,path);
            path.remove(path.size()-1);
        }
    }
}