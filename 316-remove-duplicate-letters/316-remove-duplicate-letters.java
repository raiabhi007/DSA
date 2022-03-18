class Solution {
    public String removeDuplicateLetters(String s) {
           int[] visited = new int[26];
        HashMap<Character, Integer> hmap =  new HashMap<>();
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) hmap.put(s.charAt(i), i);
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
			
            if(visited[curr - 'a'] == 1) continue;
			
            while(!stack.isEmpty() && curr < stack.peek() && i < hmap.get(stack.peek())){
                visited[stack.pop() - 'a'] = 0;
            }
            stack.push(curr);
            visited[curr - 'a'] = 1;
        }
        
        StringBuilder sb = new StringBuilder();   
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}