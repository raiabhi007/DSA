class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> hmap = new HashMap<>();
        for(String s : strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            if(!hmap.containsKey(str))
            hmap.put(str,new ArrayList<>());
            
            hmap.get(str).add(s);
        }
        res.addAll(hmap.values());
        return res;
    }
}