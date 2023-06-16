class Solution {
    private static final int MOD = 1000000007;

    public int numOfWays(int[] nums) {
        return (int) countWays(nums) - 1; // Subtract 1 to exclude the original ordering
    }

    private long countWays(int[] nums) {
        if (nums.length <= 2) {
            return 1; // Base case: There's only one or two elements, so there's only one way to reorder them
        }

        int root = nums[0];

        int[] smaller = getSmallerElements(nums, root);
        int[] larger = getLargerElements(nums, root);

        long countSmaller = countWays(smaller);
        long countLarger = countWays(larger);

        long count = nCr(nums.length - 1, smaller.length) % MOD; // Calculate the number of ways to reorder the root and smaller elements
        count = (count * countSmaller) % MOD; // Multiply by the number of ways to reorder the smaller elements
        count = (count * countLarger) % MOD; // Multiply by the number of ways to reorder the larger elements

        return count;
    }

    private int[] getSmallerElements(int[] nums, int root) {
        List<Integer> smaller = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) {
                smaller.add(nums[i]);
            }
        }
        return toArray(smaller);
    }

    private int[] getLargerElements(int[] nums, int root) {
        List<Integer> larger = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > root) {
                larger.add(nums[i]);
            }
        }
        return toArray(larger);
    }

    private int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private long nCr(int n, int r) {
        long[][] dp = new long[n + 1][r + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        return dp[n][r];
    }
}