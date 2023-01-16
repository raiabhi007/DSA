class Solution {
   int largestarea(int arr[], int n) {
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j] = 0;
            }
            int area = largestarea(height,height.length);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}