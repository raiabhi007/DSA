class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> op = new ArrayList<>();
        for (String word : words) {
            set.remove(word);
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.substring(0, i+1))) {
                    if (helper(word.substring(i + 1), set)) {
                        op.add(word);
                        break;
                    }
                }
            }
            set.add(word);
        }
        return op;
    }
    
    private boolean helper(String s, Set<String> set) {
        if (s.length() == 0)
            return true;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i+1)))
                if (helper(s.substring(i+1), set))
                    return true;
        }
        return false;
    }
}