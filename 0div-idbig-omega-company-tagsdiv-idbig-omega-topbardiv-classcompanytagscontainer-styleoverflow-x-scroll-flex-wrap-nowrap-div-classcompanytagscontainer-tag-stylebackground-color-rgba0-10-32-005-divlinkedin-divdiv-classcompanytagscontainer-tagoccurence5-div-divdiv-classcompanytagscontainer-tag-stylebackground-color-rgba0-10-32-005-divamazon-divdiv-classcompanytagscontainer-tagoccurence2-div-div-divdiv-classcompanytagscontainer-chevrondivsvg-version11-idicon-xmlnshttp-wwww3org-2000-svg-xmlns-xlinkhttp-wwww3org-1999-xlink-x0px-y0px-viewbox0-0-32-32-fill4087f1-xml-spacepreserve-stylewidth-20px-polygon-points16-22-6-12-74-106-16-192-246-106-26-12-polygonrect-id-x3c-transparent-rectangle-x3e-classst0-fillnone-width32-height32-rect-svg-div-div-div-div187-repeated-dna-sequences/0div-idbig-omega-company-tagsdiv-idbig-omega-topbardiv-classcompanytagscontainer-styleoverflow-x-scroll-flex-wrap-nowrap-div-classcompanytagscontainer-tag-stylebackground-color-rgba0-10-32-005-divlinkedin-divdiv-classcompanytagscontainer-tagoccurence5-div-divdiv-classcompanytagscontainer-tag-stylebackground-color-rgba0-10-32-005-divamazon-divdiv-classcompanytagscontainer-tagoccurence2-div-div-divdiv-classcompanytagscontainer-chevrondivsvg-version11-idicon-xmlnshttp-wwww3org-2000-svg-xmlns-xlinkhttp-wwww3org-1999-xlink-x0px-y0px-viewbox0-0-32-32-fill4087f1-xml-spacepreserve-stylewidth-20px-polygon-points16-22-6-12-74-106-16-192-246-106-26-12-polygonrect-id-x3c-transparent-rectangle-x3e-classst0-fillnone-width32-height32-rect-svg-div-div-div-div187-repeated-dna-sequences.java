class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length()<=10) return ans;
        HashMap<String,Integer> map = new HashMap<>();
        String temp = "";
        for(int i=0;i<10;i++)
            temp+=s.charAt(i);
        map.put(temp,1);
        for(int i=10;i<s.length();i++){
            temp = temp.substring(1)+s.charAt(i);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for(String st:map.keySet()){
            if(map.get(st)>1) ans.add(st);
        }
        return ans;
    }
}