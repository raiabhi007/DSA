class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int j = manager[i];
            if(!graph.containsKey(j))
                graph.put(j,new ArrayList<>());
            graph.get(j).add(i);
        }
        return dfs(graph,informTime,headID);
    }
    public int dfs(Map<Integer,List<Integer>> graph,int[] informTime,int cur){
        int max = 0;
        if(!graph.containsKey(cur))
            return max;
        for(int it:graph.get(cur))
            max = Math.max(max,dfs(graph,informTime,it));
        return max+informTime[cur];
    }
}