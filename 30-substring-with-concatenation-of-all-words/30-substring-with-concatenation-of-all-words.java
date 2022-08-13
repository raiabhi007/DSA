class Solution {
    
    private boolean compareMaps(HashMap<String, Integer> map, HashMap<String, Integer> tempMap){
        for(Map.Entry<String, Integer> e : map.entrySet()){
            if(tempMap.containsKey(e.getKey()) == false){
                return false;
            }
            else{
                if(e.getValue().intValue() != tempMap.get(e.getKey()).intValue()){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int w = words.length;
        int l = words[0].length();
        int size = w * l;
        int i, j, k;
        List<Integer> ans = new ArrayList<Integer>();

        HashMap<String, Integer> map = new HashMap<>();
        for(i=0;i<w;i++){
            if(map.containsKey(words[i]) == false){
                map.put(words[i], 1);
            }
            else{
                map.put(words[i], map.get(words[i])+1);
            }
        }
        
        for(j=0 ; j<=n-size ; j++){
            String s1 = s.substring(j, j+l);
            if(map.containsKey(s1) == true){
                HashMap<String, Integer> tempMap = new HashMap<>();
                tempMap.put(s1, 1);
                int count = 2;
                for(k=j+l;count<=w;){
                    String s2 = s.substring(k, k+l);
                    if(map.containsKey(s2) == true){
                        if(tempMap.containsKey(s2) == false){
                            tempMap.put(s2, 1);
                        }
                        else{
                            tempMap.put(s2, tempMap.get(s2)+1);
                        }
                    }
                    k = k + l;
                    count++;
                }

                if(compareMaps(map, tempMap)){
                    ans.add(j);
                }
            }
        }
        
        return ans;
    }
}