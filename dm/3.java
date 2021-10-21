class Solution {
  public int lengthOfLongestSubstring(String s) {
      Set<Character> subStrSet = new HashSet<Character>();

      int rightPointer = -1; // 右指针
      int answer = 0;

      for (int i = 0; i < s.length(); i++) {
          // 移除上次循环的字符
          if (i > 0) {
              subStrSet.remove(s.charAt(i - 1));
          }

          while(rightPointer + 1 < s.length() && !subStrSet.contains(s.charAt(rightPointer + 1))) {
              subStrSet.add(s.charAt(rightPointer + 1));
              rightPointer++;
          }

          answer = Math.max(answer, subStrSet.size());
      }

      return answer;
  }
}