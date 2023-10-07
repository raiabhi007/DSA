class Solution {
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
        long upperRight = 0;
        long lowerLeft = 0;
        for(int i=0;i<grid[0].length;i++)
            upperRight+=grid[0][i];
        for(int i=0;i<grid[0].length;i++){
            upperRight-=grid[0][i];
            ans = Math.min(ans,Math.max(upperRight,lowerLeft));
            lowerLeft+=grid[1][i];
        }
        return ans;
    }
}