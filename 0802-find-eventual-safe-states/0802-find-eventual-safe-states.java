class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
            adjRev.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
                adjRev.get(graph[i][j]).add(i);
        }
        int V = graph.length;
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adjRev.get(i))
                indegree[it]++;
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++)
            if(indegree[i]==0)
                q.add(i);
        
        while(!q.isEmpty()){
            int node = q.remove();
            ans.add(node);
            for(int it:adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}