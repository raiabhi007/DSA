class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(hmap.get(ch)!=null){
             Integer c = hmap.get(ch)+1;
                hmap.put(ch,c);
            }else{
             hmap.put(ch,1);               
            }
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(hmap.get(ch)==1)
                return i;
        }
        return -1;
    }
}