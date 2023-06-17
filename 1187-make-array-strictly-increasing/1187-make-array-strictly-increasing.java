class Solution {
    public static int INVALID = 1000000001;//10e9 + 1
    public static int SIZE = 2000 + 5;
    public int[][] dp = new int[SIZE][SIZE];

    public int findBiggerNumber(int[] arr, int number) {
        int left = 0, right = arr.length, index = -1;
        while (right > left) {
            int mid = (right + left) / 2;
            if (arr[mid] <= number) {
                left = mid + 1;
            } else {
                right = mid;
                index = mid;
            }
        }
        if (index >= 0 && index < arr.length) {
            return arr[index];
        }
        return INVALID;
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int res = -1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j <= arr1.length; j++) {
                dp[i][j] = INVALID;
            }
        }
        Arrays.sort(arr2);
        dp[0][0] = arr1[0];
        dp[0][1] = arr2[0];
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 0; j <= i + 1; j++) {
                if (j == 0) {//zero time's make
                    int lastMadeNumber = dp[i - 1][j];
                    dp[i][j] = lastMadeNumber == INVALID ? INVALID : (lastMadeNumber < arr1[i] ? arr1[i] : INVALID);
                } else {
                    int lastMadeNumber = dp[i - 1][j];
                    dp[i][j] = lastMadeNumber == INVALID ? INVALID : (lastMadeNumber < arr1[i] ? arr1[i] : INVALID);

                    int temp = dp[i - 1][j - 1];
                    int biggerNumber = findBiggerNumber(arr2, temp);
                    dp[i][j] = Math.min(dp[i][j], biggerNumber);
                }
            }
        }
//        for (int i = 0; i <= arr1.length; i++) {
//            for (int j = 0; j < arr1.length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i <= arr1.length; i++) {
            int temp = dp[arr1.length - 1][i];
            if (temp != INVALID) {
                return i;
            }
        }
        return res;
    }
}