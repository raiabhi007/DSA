class Solution {
    public boolean winnerOfGame(String colors) {
        int i=-1;int j=0;
        int alice = 0;
        for(j=0;j<colors.length();j++){
            char ch = colors.charAt(j);
            if(ch=='B'){
                int diff = j-i-1;
                if(diff>=3) alice+=(diff-2);
                i=j;
            }
        }
        if(j-i-1>=3) alice+=(j-i-1-2);
        i=-1;
        j=0;
        int bob=0;
         for(j=0;j<colors.length();j++){
            char ch = colors.charAt(j);
            if(ch=='A'){
                int diff = j-i-1;
                if(diff>=3) bob+=(diff-2);
                i=j;
            }
        }
        if(j-i-1>=3) bob+=(j-i-1-2);
        if(alice==bob) return false;
        return alice>bob;
    }
}