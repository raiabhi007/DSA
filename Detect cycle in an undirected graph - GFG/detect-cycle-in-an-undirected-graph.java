//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second; 
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(parent,-1);
        
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(checkForCycle(adj,i,vis,parent)) return true;
            }
        }
        return false;
    }
    public boolean checkForCycle(ArrayList<ArrayList<Integer>> adj,int i,boolean[] vis, int[] parent){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i,-1));
        vis[i] = true;
        
        while(!q.isEmpty()){
            int src = q.peek().first;
            int par = q.peek().second;
            q.poll();
            
            for(Integer it:adj.get(src)){
                if(vis[it]==false){
                    q.add(new Node(it,src));
                    vis[it] = true;
                }else if(par!=it) return true;
            }
        }
        return false;
    }
}