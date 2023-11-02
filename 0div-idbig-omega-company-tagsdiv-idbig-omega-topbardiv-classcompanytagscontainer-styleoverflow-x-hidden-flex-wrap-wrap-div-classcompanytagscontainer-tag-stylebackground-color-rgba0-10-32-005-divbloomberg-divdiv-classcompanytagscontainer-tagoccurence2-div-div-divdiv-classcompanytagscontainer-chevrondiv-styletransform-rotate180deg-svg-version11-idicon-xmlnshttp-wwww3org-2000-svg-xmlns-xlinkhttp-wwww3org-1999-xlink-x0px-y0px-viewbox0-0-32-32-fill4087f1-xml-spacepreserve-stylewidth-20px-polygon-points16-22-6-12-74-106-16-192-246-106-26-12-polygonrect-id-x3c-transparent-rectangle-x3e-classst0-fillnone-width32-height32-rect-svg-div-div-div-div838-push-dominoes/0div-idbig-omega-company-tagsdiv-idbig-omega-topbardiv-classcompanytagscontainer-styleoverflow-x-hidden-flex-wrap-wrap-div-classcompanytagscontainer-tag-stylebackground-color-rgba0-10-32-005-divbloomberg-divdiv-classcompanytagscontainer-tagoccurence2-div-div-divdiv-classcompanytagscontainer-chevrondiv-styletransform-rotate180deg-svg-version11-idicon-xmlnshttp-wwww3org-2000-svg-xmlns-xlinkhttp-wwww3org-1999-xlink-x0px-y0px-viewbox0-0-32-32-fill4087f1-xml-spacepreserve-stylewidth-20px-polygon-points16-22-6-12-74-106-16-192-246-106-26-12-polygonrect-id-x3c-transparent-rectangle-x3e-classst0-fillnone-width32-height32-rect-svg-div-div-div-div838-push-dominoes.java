class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != '.')
                q.add(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            char c = sb.charAt(curr);

            if(curr-1 >= 0 && c == 'L' && sb.charAt(curr-1) == '.'){
                q.add(curr-1);
                sb.setCharAt(curr-1, 'L');
            }
            else if(c == 'R'){
                if(curr+1 < sb.length() && sb.charAt(curr+1) == '.'){
                    if(curr+2 < sb.length() && sb.charAt(curr+2) == 'L'){
                        q.poll();
                    }
                    else{
                        q.add(curr+1);
                        sb.setCharAt(curr+1, 'R');
                    }
                }
            }
        }

        return sb.toString();
    }
}