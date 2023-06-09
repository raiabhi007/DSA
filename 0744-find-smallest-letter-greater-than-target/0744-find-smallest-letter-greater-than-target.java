class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    for (var letter : letters)
      if (letter > target) return letter;
    
    return letters[0];
  }
}