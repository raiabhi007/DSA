class NumMatrix {
    int[][] sums;
    int maxRow, maxCol;
    public NumMatrix(int[][] matrix) {
        int temp;
        maxRow = matrix.length;
        maxCol = matrix[0].length;
        sums = new int[maxRow+1][maxCol+1];
		// 0th row and 0th col will always have 0. Thus never accessed.
		// First take row wise sum to the matrix.
        for(int i = 1; i<=maxRow; i++) {
            temp = 0;
            for(int j = 1; j<=maxCol; j++) {
                temp += matrix[i-1][j-1];
                sums[i][j] = temp;
            }
        }
		// After taking row wise sum we add colum wise sum to the matrix.
        for(int i = 1; i<=maxRow; i++) {
            for(int j = 1; j<=maxCol; j++) {
                sums[i][j] += sums[i-1][j];
            }
        }
    }
   
	// As described above , ans = S-U-L+D.
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int diag, upper, left, ans;
        diag = sums[row1][col1];
        upper = sums[row1][col2+1];
        left = sums[row2+1][col1];
        ans = sums[row2+1][col2+1];
        return ans - upper - left + diag;
    }
}