class Solution {
    ArrayList<ArrayList<Integer>> adj;
    public int longestPath(int[] parent, String s) 
    {
        int n = parent.length;
        adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=1;i<n;i++)
            adj.get(parent[i]).add(i);
        
        dfs(0, s);
        return res;
    }
    
    int res = 1;
    public int dfs(int u, String str)
    {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer v: adj.get(u))
        {
            int count = dfs(v, str);
            if(str.charAt(u)!=str.charAt(v))
            {
                pq.add(count);
                if(pq.size() > 2)//At max only 3 elements could be present which is better than storing the result for all branches of tree.
                    pq.poll();
            }
        }
        int x1 = pq.isEmpty() ? 0 : pq.poll();
        int x2 = pq.isEmpty() ? 0 : pq.poll();
        res = Math.max(res, x2 + x1 + 1);
        return (x2 == 0 ? x1 : x2) + 1;
    }
}