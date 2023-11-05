class Solution {
    public int partitionString(String s){
        int i=0;
        int j=0;
        int ans = 0;
        while(j<s.length()){
            HashSet<Character> set = new HashSet<>();
            while(j<s.length()){
                if(set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
                j++;
            }
            ans++;
        }
        return ans;
    }
}