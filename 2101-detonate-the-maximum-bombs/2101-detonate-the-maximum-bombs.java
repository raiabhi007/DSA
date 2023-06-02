class Solution {
      public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                
                if(canDetonate(bombs[i][0], bombs[i][1], bombs[i][2], bombs[j][0], bombs[j][1])) {
                    graph.get(i).add(j);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dfs(graph, new boolean[n], i));
        }
        
        return max;
    }
    
    private int dfs(List<List<Integer>> graph, boolean[] vis, int src) {        
        vis[src] = true;
        int res = 1;
        for(int next: graph.get(src)) {
            if(vis[next]) continue;
            res += dfs(graph, vis, next);
        }
        return res;
    }
    
    public boolean canDetonate(int x1, int y1, int r, int x2, int y2) {
            double dist = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
            return r >= dist;
    }
}