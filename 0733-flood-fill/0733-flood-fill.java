class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean visited[][] = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,newColor,oldColor,visited);
        return image;
    }
    public void dfs(int[][] image,int sr,int sc,int newColor,int oldColor,boolean[][] visited){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||visited[sr][sc]==true||image[sr][sc]!=oldColor)
            return;
            image[sr][sc] = newColor;
            visited[sr][sc] = true;
            dfs(image,sr-1,sc,newColor,oldColor,visited);
            dfs(image,sr,sc-1,newColor,oldColor,visited);
            dfs(image,sr+1,sc,newColor,oldColor,visited);
            dfs(image,sr,sc+1,newColor,oldColor,visited);
        
    }
}