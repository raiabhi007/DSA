class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<letters.length;i++){
            if(!map.containsKey(letters[i])){
                map.put(letters[i],1);
            }else
                map.put(letters[i],map.get(letters[i])+1);
        }
        return backtrack(0,words,score,map);
        
    }
    private int backtrack(int idx, String[] words,int[] score,HashMap<Character,Integer> map){
        if(idx==words.length) return 0;
        int exc = backtrack(idx+1,words,score,map);
         int sum = 0;
         int i=0;
        for(i=0;i<words[idx].length();i++){
            char c = words[idx].charAt(i);
            if(map.containsKey(c)){
                sum+=score[c-'a'];
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) map.remove(c);
            }else{
                sum = 0;
                break;
            }
        }
        int inc = 0;
        if(sum!=0)
        inc = sum+backtrack(idx+1,words,score,map);
        for(int j=0;j<i;j++){
            char c = words[idx].charAt(j);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else
                map.put(c,map.get(c)+1);
        }
        return Math.max(inc,exc);
    }
}