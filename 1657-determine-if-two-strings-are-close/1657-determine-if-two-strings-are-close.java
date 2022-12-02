class Solution {
   public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())  return false;    // Not same length strings.
        if (word1.equals(word2))  return true;                  // Both strings identical.
       
        int[] freq1 = new int[128];     
        int[] freq2 = new int[128];     
        for (char c : word1.toCharArray())  freq1[c]++;
        for (char c : word2.toCharArray())  freq2[c]++;
        
        int maxFreq = 0;
        for (int i = 'a'; i <= 'z'; i++)
            maxFreq = Math.max(maxFreq, Math.max(freq1[i], freq2[i]));
        byte[] freqFreq = new byte[maxFreq + 1];    // Up/down counters for any frequency 
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            int f1 = freq1[i];
            int f2 = freq2[i];
            if ((f1 == 0) ^ (f2 == 0))  return false;  
            if (f1 != 0) {
                int f1f = freqFreq[f1]++;
                int f2f = freqFreq[f2]--;
                if (f1f == 0)  count++;  else  if (f1f == -1)  count--;
                if (f2f == 0)  count++;  else  if (f2f ==  1)  count--;
            }
        }
        return count == 0;  
    }
}