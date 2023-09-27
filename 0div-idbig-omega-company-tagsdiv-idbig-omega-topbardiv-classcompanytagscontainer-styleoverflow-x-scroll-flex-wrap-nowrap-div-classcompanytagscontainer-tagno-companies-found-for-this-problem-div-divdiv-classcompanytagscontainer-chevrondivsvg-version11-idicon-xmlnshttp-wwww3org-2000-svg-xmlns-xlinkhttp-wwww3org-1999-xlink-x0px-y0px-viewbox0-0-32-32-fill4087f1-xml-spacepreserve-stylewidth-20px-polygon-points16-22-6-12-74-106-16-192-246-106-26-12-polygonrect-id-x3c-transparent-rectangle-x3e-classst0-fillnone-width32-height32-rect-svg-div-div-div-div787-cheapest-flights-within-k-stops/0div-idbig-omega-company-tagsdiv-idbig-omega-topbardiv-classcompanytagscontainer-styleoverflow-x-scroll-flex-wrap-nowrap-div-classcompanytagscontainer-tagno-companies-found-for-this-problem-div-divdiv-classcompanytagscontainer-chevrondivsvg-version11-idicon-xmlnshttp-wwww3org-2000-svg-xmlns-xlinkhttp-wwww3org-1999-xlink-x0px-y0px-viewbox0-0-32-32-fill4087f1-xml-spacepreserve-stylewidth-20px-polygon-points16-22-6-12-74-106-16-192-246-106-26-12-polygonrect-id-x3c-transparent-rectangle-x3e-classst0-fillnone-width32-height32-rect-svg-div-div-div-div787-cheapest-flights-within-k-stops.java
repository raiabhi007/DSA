class Pair{
    int first;
    int second;
    public Pair(int f,int s){
        this.first = f;
        this.second = s;
    }
}

class Tuple{
    int stops;
    int node;
    int distance;
    public Tuple(int stops,int node,int distance){
        this.stops = stops;
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        Queue<Tuple> q = new LinkedList<>();
        int dist[] = new int[n];
        Tuple t = new Tuple(0,src,0);
        q.add(t);
        Arrays.fill(dist,(int)1e9);
        while(!q.isEmpty()){
            Tuple cur = q.poll();
            int stops = cur.stops;
            int node = cur.node;
            int distance = cur.distance;
            
            for(int i=0;i<adj.get(node).size();i++){
                int destination = adj.get(node).get(i).first;
                int amt = adj.get(node).get(i).second;
                
                if(stops<=k&&amt+distance<dist[destination]){
                    dist[destination] = amt+distance;
                    q.add(new Tuple(stops+1,destination,amt+distance));
                }
            }
        }
        int ans = dist[dst];
        if(ans==(int)1e9) return -1;
        return ans;
    }
}