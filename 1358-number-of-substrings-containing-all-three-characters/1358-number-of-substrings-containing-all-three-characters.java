class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        int total = 0;
        for(int j=0;j<s.length();j++){
            char rightChar = s.charAt(j);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            while(map.size()>=3){
                char leftChar = s.charAt(i);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0)
                    map.remove(leftChar);
                i++;
            }
            total+=i;
        }
        return total;
    }
}