class Solution {
    public int countPalindromicSubsequence(String s) {
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first,-1);
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(first[ch-'a']==-1)
                first[ch-'a'] = i;
            last[ch-'a'] = i;
        }
        
        int ans = 0;
        int count = 0;
        boolean[] visited;
        
        for(int i=0;i<26;i++){
            int si = first[i];
            int ei = last[i];
            if(si==-1) continue;
            visited = new boolean[26];
            count = 0;
            for(int j=si+1;j<ei;j++){
                char ch = s.charAt(j);
                if(!visited[ch-'a']){
                    visited[ch-'a'] = true;
                    count++;
                }
            }
            ans+=count;
        }
        return ans;
    }
}