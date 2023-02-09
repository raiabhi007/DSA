class Solution {
    public long distinctNames(String[] ideas) {
         ArrayList<String> a[]= new ArrayList[26];
        long res =0;
        for(int i=0;i<26;i++) 
        a[i] = new ArrayList<>();
        
        for(String s : ideas){ 
           a[s.charAt(0)-'a'].add(s.substring(1,s.length()));     
        }
        
        for(int i=0;i<25;i++){
            for(int j=i+1;j<26;j++){
                HashSet<String> hs = new HashSet<>();
                hs.addAll(a[i]);
                hs.addAll(a[j]);
                res += 2 * (a[i].size() - hs.size()) * (a[j].size() - hs.size());
            }
        }
		return res;
    }
}