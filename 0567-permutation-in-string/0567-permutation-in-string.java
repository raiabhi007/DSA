class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int hash[] = new int[26];
        for(int i=0;i<s1.length();i++){
            hash[s1.charAt(i)-'a']++;
        }
        int end = 0;
        int start = 0;
        int diff = s1.length();
        for(end=0;end<s1.length();end++){
            char temp = s2.charAt(end);
            hash[temp-'a']--;
            if(hash[temp-'a']>=0)
                diff--;
        }
        if(diff==0)
            return true;
        char temp;
        while(end<s2.length()){
           temp = s2.charAt(start);
           if(hash[temp-'a']>=0)
               diff++;
           hash[temp-'a']++; 
           start++;
            temp = s2.charAt(end);
            hash[temp-'a']--;
            if(hash[temp-'a']>=0)
                diff--;
            if(diff==0)
                return true;
            end++;
        }
            return false;
    }
}