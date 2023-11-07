class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        int j=0;
        int n = word1.length();
        int m = word2.length();
        String ans = "";
        while(i<n&&j<m){
            ans+=word1.charAt(i++);
            ans+=word2.charAt(j++);
        }
        while(i<n)
            ans+=word1.charAt(i++);
        while(j<m)
            ans+=word2.charAt(j++);
        return ans;
    }
}