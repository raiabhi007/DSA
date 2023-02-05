class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length()==0||p.length()==0||p.length()>s.length())
            return ans;
        int hash[] = new int[26];
        for(char ch:p.toCharArray()){
            hash[ch-'a']++;
        }
        int start = 0,end=0,len=p.length(),diff = len;
        char temp;
        for(end=0;end<len;end++){
            temp = s.charAt(end);
            hash[temp-'a']--;
            if(hash[temp-'a']>=0)
                diff--;
        }
        if(diff==0)
            ans.add(0);
        while(end<s.length()){
            temp = s.charAt(start);
            if(hash[temp-'a']>=0)
                diff++;
            hash[temp-'a']++;
            start++;
            temp = s.charAt(end);
            hash[temp-'a']--;
            if(hash[temp-'a']>=0)
                diff--;
            if(diff==0)
                ans.add(start);
            end++;
        }
        return ans;
    }
}