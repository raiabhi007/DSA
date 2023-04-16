class Solution {
    public int numWays(String[] words, String target) {
        long []dp = new long[target.length()];
        long mod = 1000000007;
        for(int i=0;i<words[0].length();i++){
            int []a = new int[26];
            for(int j=0;j<words.length;j++){
                a[words[j].charAt(i)-'a'] ++;
            }
            for(int j= Math.min(i, target.length()-1);j>=0;j--){
                if(a[target.charAt(j) - 'a'] > 0){
                    dp[j] += j == 0 ? a[target.charAt(j)-'a'] : dp[j-1]*a[target.charAt(j)-'a'];
                    dp[j] %= mod;
                }
            }
        }
        return (int)dp[dp.length-1];
    }
}