class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[256];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hash[ch]++;
        }
         for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            hash[ch]--;
        }
        for(int i=0;i<hash.length;i++){
            if(hash[i]!=0)
                return false;
        }
        return true;
    }
}