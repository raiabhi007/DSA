class Solution {
    class Node implements Comparable<Node> {
        int start;
        int end;
        int wei;
        int index;
        public Node(int start , int end , int wei , int index){
            this.start = start;
            this.end = end;
            this.wei = wei;
            this.index = index;
        }
        public int compareTo(Node node){
            return this.wei - node.wei;
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] e, int[][] q) {
        boolean[] ans = new boolean[q.length];
        Disjoint dis = new Disjoint(n);
        Arrays.sort(e , (a , b) -> (a[2] - b[2]));
        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 0 ; i < q.length ; i++){
            arr.add(new Node(q[i][0] , q[i][1] , q[i][2] , i));
        }
        int ptr = -1;
        Collections.sort(arr);
        for(int i = 0 ; i < arr.size() ; i++){
            int start = arr.get(i).start;
            int end = arr.get(i).end;
            int wei = arr.get(i).wei;
            int index = arr.get(i).index;
            while(ptr + 1 < e.length && e[ptr+1][2] < wei){
                ptr++;
                dis.mergeBySize(e[ptr][0] , e[ptr][1]);
            }
            if(dis.isConnected(start , end)){
                ans[index] = true;
            }else{
                ans[index] = false;
            }
        }
        return ans;
    }
    class Disjoint{
        int n;
        int[] parent;
        int[] rank;
        int[] size;
        public Disjoint(int n){
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            Arrays.fill(size , 1);
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }
        public int find(int node){
            if(node != parent[node]){
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }
        private void merge(int node1 , int node2){
            int p1 = find(node1);
            int p2 = find(node2);
            if(p1 == p2) return;
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
                rank[p2]++;
            }else{
                parent[p1] = p2;
                rank[p1]++;
            } 
        }
        private void mergeBySize(int node1 , int node2){
            int p1 = find(node1);
            int p2 = find(node2);
            if(p1 == p2) return;
            if(size[p1] > size[p2]){
                parent[p2] = p1;
                size[p1] += size[p2];
            }else{
                parent[p1] = p2;
                size[p2] += size[p1];
            }
        }
        private boolean isConnected(int node1 , int node2){
            return find(node1) == find(node2);
        }
    }
}