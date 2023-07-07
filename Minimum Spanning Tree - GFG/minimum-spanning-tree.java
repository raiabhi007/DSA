//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};

class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    
    public void unionBySize(int u,int v){
        int ulp_u = parent.get(u);
        int ulp_v = parent.get(v);
        if(ulp_v==ulp_u) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<Edge> Edges = new ArrayList<Edge>();
	    for(int i=0;i<E;i++){
	        Edges.add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
	    }
	    Collections.sort(Edges);
	    int mstWt = 0;
	    DisjointSet ds = new DisjointSet(V);
	    
	    for(int i=0;i<Edges.size();i++){
	        int wt = Edges.get(i).weight;
	        int u = Edges.get(i).src;
	        int v = Edges.get(i).dest;
	        if(ds.findUPar(u)!=ds.findUPar(v)){
	            ds.unionBySize(u,v);
	            mstWt+=wt;
	        }
	    }
	    return mstWt;
	}
}