class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int count[] = new int[26];
        for(int i=0;i<letters.length;i++){
            count[letters[i]-'a']++;
        }
        return backtrack(0,words,score,count);
        
    }
    private int backtrack(int idx, String[] words,int[] score,int[] count){
        if(idx==words.length) return 0;
        int exc = backtrack(idx+1,words,score,count);
         int sum = 0;
         int i=0;
        for(i=0;i<words[idx].length();i++){
            char c = words[idx].charAt(i);
            if(count[c-'a']>0){
                sum+=score[c-'a'];
                count[c-'a']--;
            }else{
                sum = 0;
                break;
            }
        }
        int inc = 0;
        if(sum!=0)
        inc = sum+backtrack(idx+1,words,score,count);
        for(int j=0;j<i;j++){
            char c = words[idx].charAt(j);
            count[c-'a']++;
        }
        return Math.max(inc,exc);
    }
}