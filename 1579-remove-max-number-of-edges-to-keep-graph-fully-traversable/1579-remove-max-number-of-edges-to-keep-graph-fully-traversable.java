class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);

        int edgesRequired = 0;

        for (int[] edge : edges) {
            int type = edge[0], node1 = edge[1], node2 = edge[2];
            if (type != 3) continue;

            boolean nodesConnectedAlice = Alice.union(node1, node2);
            boolean nodesConnectedBob = Bob.union(node1, node2);

            if (nodesConnectedAlice || nodesConnectedBob) edgesRequired += 1;
        }

        for (int[] edge : edges) {
            int type = edge[0], node1 = edge[1], node2 = edge[2];

            if (type == 1 && Alice.union(node1, node2)) edgesRequired += 1;
            else if (type == 2 && Bob.union(node1, node2)) edgesRequired += 1;
        }

        if (Alice.isNotConnected() || Bob.isNotConnected()) return -1;

        return edges.length - edgesRequired;
    }
}

class UnionFind {
    private int[] rank;
    private int[] root;
    private int countSets;

    public UnionFind(int size) {
        rank = new int[size + 1];
        root = new int[size + 1];
        countSets = size;

        for (int i = 0; i <= size; i++) {
            rank[i] = 1;
            root[i] = i;
        }
    }

    public int find(int x) {
        if (x == root[x]) return x;
        return root[x] = find(root[x]);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        if (rank[rootX] > rank[rootY]) root[rootY] = rootX;
        else if (rank[rootX] < rank[rootY]) root[rootX] = rootY;
        else {
            root[rootX] = rootY;
            rank[rootY] += 1;
        }
        countSets -= 1;

        return true;
    }

    public boolean areConnected(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        return root1 == root2;
    }

    public boolean isNotConnected() {
        return countSets != 1;
    }
}