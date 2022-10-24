class Solution {
     public int maxLength(List<String> arr) {
        Str[] strs = new Str[arr.size()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = new Str(arr.get(i));
        }
        
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            max = Math.max(search(strs, i, 0), max);
        }
        return max;
    }
    
    private int search(Str[] str, int idx, int acc) {
        if (idx == str.length) return 0;
        if (!str[idx].usable || (acc & str[idx].key) != 0) return 0;
        int max = 0;
        int key = str[idx].key | acc;
        for (int i = idx + 1; i < str.length; i++) {
            max = Math.max(search(str, i, key), max);
        }
        return str[idx].len + max;
    }
    
    class Str {
        int key = 0;
        int len = 0;
        boolean usable = true;
        
        public Str (String s) {
            for (char c : s.toCharArray()) {
                int bit = (1 << (c - 'a'));
                if ((bit & key) != 0) {
                    usable = false;
                    break;
                }
                key = key | (1 << (c - 'a'));
            }
            len = s.length();
        }
    }
}