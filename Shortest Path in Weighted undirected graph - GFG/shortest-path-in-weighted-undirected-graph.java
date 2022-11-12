//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int distance;
    public Pair(int first,int second){
        this.node=first;
        this.distance = second;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i] = (int)(1e9);
            parent[i] = i;
        }
        dist[1] = 0;
        pq.add(new Pair(1,0));
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for(Pair iter:adj.get(node)){
                int adjNode = iter.node;
                int edgeWeight = iter.distance;
                if(dis+edgeWeight<dist[adjNode]){
                    dist[adjNode] = dis+edgeWeight;
                    pq.add(new Pair(adjNode,dist[adjNode]));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n]==1e9){
        path.add(-1);
        return path;
        }
        int node = n;
        while(parent[node]!=node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}