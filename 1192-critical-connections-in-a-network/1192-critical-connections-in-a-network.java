class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<connections.size();i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        
        int[] low = new int[n];
        int[] time = new int[n];
        int[] vis = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,-1,adj,vis,time,low,ans);
        return ans;
    }
   public void dfs(int node,int parent, ArrayList<ArrayList<Integer>> adj,int[] vis,int[] time,int[] low,List<List<Integer>> ans){
       vis[node] = 1;
       time[node] = low[node] = timer;
       timer++;
       for(Integer it:adj.get(node)){
           if(it==parent) continue;
           if(vis[it]==0){
               dfs(it,node,adj,vis,time,low,ans);
               low[node] = Math.min(low[node],low[it]);
               if(low[it]>time[node])
                   ans.add(Arrays.asList(it,node));
           }else
               low[node] = Math.min(low[node],low[it]);
       }
   } 
}