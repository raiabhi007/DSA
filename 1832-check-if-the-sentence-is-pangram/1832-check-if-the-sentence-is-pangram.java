class Solution {
    public boolean checkIfPangram(String sentence) {
        int hash[] = new int[26];
        if(sentence.length()<26)
            return false;
        int count = 0;
        for(int i=0;i<sentence.length();i++){
            char ch = sentence.charAt(i);
            if(hash[ch-'a']==0)
                count++;
            hash[ch-'a']++;
            if(count==26)
                return true;
        }
        if(count==26)
            return true;
        return false;
    }
}