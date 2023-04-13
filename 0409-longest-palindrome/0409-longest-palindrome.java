class Solution {
    public int longestPalindrome(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : chars){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int len = 0;
        boolean odd = false;
        for(char k : map.keySet()){
            if(map.get(k) % 2 == 0){
                len += map.get(k);
            }
            
            else{
                odd = true;
                len += map.get(k) - 1;
            }
        }
        return len + (odd ? 1 : 0);
    }
}