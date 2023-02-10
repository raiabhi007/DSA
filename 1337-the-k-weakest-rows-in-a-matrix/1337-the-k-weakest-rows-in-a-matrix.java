class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> q = new PriorityQueue<>((i,j) ->{if(i[1] > j[1]) return 1; if(i[1] < j[1]) return -1; if(i[0] > j[0]) return 1;return -1;});
        for(int i=0;i<mat.length;i++){
            int sum = 0;
            for(int j=0;j<mat[0].length;j++) sum+=mat[i][j];
            q.add(new int[]{i,sum});
        }
        int idx = 0;
        while(k-->0) res[idx++] = q.poll()[0];
        return res;
    }
}