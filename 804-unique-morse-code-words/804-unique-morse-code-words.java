class Solution {
    private static final String[] ALPHABET = new String[] {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
        "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };
    
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();
        
        for (String word: words) {
            int w = word.length();
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < w; i++) {
                String morse = ALPHABET[word.charAt(i) - 'a'];
                sb = sb.append(morse);
            }
            String transformation = sb.toString();
            transformations.add(transformation);
        }
        
        return transformations.size();
    }
}