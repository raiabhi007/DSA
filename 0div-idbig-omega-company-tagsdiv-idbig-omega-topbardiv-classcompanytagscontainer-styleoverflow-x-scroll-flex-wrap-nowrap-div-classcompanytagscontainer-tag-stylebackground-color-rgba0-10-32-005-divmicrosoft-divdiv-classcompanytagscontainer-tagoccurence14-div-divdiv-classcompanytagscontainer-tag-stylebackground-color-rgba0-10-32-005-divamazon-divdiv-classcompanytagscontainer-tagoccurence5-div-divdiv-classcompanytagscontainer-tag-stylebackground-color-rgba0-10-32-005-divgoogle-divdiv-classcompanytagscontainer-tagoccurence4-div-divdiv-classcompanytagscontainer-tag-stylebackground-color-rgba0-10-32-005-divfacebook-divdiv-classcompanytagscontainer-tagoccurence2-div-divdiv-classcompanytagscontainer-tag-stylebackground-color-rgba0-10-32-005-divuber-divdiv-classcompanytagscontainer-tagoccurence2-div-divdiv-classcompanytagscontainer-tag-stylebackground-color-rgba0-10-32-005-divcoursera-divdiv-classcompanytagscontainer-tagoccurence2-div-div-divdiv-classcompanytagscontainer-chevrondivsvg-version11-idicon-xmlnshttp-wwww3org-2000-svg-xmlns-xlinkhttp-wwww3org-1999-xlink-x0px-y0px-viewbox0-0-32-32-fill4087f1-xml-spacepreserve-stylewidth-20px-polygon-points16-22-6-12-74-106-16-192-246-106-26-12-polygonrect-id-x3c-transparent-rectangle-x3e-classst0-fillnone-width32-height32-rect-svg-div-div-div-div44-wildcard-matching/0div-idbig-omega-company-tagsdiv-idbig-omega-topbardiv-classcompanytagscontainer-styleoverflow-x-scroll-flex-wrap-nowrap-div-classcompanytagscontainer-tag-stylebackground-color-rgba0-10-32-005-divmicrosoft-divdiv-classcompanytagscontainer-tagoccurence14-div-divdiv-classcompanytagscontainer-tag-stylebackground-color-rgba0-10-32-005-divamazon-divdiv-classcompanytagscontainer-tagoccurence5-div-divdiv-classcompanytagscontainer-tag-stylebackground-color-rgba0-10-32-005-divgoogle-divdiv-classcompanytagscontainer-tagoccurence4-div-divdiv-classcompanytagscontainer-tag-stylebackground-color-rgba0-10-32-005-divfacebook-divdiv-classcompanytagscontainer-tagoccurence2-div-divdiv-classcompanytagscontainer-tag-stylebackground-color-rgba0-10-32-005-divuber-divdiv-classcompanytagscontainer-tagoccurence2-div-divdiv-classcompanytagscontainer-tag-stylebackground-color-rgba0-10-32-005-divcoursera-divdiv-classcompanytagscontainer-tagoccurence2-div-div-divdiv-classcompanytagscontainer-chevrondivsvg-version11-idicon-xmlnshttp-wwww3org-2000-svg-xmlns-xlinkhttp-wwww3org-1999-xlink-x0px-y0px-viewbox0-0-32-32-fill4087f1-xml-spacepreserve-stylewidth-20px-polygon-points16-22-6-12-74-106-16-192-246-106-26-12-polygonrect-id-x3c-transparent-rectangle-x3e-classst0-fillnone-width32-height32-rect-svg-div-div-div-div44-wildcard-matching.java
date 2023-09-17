class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,s,p,dp);
    }
    public boolean helper(int i,int j,String s,String p,int[][] dp){
        if(i==s.length()&&j==p.length()) return true;
        else if(j==p.length()) return false;
        else if(i==s.length()&&p.charAt(j)!='*') return false;
        else if(i>s.length()) return false;
        
        if(dp[i][j]!=-1) return dp[i][j]==1?true:false;
        boolean ans = false;
        if(i<s.length()&&s.charAt(i)==p.charAt(j)){
            ans = helper(i+1,j+1,s,p,dp);
            dp[i][j] = ans==true?1:0;
            return ans;
        } 
        if(p.charAt(j)=='?'){
            ans=helper(i+1,j+1,s,p,dp);
            dp[i][j] = ans==true?1:0;
            return ans;
        } 
        
        if(p.charAt(j)=='*'){
            
            ans=helper(i+1,j+1,s,p,dp)||helper(i+1,j,s,p,dp)||helper(i,j+1,s,p,dp);
            dp[i][j]= ans==true?1:0;
            return ans;
        }
        dp[i][j] = 0;
        return false;
    }
}