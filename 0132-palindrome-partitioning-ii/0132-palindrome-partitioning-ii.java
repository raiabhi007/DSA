class Solution {
    boolean isPalindrome(char[] str,int i,int j){
        while(i<=j){
            if(str[i]!=str[j])
            return false;
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        char[] str = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 0;
        for(int i=n-1;i>=0;i--){
            int minCost = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrome(str,i,j)){
                    int cost = 1+dp[j+1];
                    minCost = Math.min(cost,minCost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0]-1;
    }
}