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

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int countEdges = 0;
        for(int i =0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUPar(u)==ds.findUPar(v)){
                countEdges++;
            }else{
                ds.unionBySize(u,v);
            }
        }
        int connectedComponents = 0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i)
                connectedComponents++;
        }
        int ans = connectedComponents-1;
        if(countEdges>=ans)
        return ans;
        return -1;
    }
}