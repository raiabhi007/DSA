class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        char ans = s.charAt(0);
        set.add(ans);
        for(int i=1;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                ans = s.charAt(i);
                break;
            }
               set.add(s.charAt(i));
        }
            return ans;
    }
    
}