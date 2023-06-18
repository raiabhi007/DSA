class Solution {
    private final long M = 1000000007;
    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int[][] grid;
    private int m, n;
    private long[][] dp;
    
    public int countPaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        
        dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        long ans = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(i, j, 0, visited)) % M;
            }
        }
        
        return (int) ans;
    }
    
    private long dfs(int i, int j, int prev, boolean[][] visited) {
        if (grid[i][j] <= prev) return 0;
        
        if (dp[i][j] > -1) return dp[i][j];
        
        long ans = 1;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                ans = (ans + dfs(x, y, grid[i][j], visited)) % M;
            }
        }
        visited[i][j] = false;
        
        dp[i][j] = ans;
        return ans;
    }
}