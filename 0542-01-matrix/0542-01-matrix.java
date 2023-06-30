class Node{
    int row;
    int col;
    int dis;
    public Node(int r,int c,int d){
        this.row = r;
        this.col = c;
        this.dis = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j] = true;
                    q.add(new Node(i,j,0));
                }
            }
        }
        int row[] = {-1,0,1,0};
        int col[] = {0,-1,0,1};
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0;i<4;i++){
                int newRow = cur.row+row[i];
                int newCol = cur.col+col[i];
                if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m&&vis[newRow][newCol]==false){
                    mat[newRow][newCol] = cur.dis+1;
                    q.add(new Node(newRow,newCol,cur.dis+1));
                    vis[newRow][newCol] = true;
                }
            }
        }
        return mat;
    }
}