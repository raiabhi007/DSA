class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int ans = 0;
        int i = s.length()-1;
        while(i>=0&&s.charAt(i)!=' '){
         i--;
         ans++;
        }
        return ans;
    }
}