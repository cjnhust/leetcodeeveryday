class Solution {
  private static final int SEG_COUTN = 4;
  private List<String> answers = new ArrayList<String>();
  private int[] segments = new int[SEG_COUTN];

  public List<String> restoreIpAddresses(String s) {
      dfs(s, 0, 0);
      return answers;
  }

  // 从字符串的charIndex位置开始，寻找segIndex这一段的地址
  private void dfs(String s, int segIndex, int charIndex) {
      if (segIndex == SEG_COUTN) { // 代表IP的4个部分都找到了
          // 且字符串刚好用完，代表找到了一个合法的IP地址
          if (charIndex == s.length()) {
              StringBuilder builder = new StringBuilder();
              for (int i = 0; i < SEG_COUTN; i++) {
                  builder.append(segments[i]);
                  if (i < SEG_COUTN - 1) {
                      builder.append(".");
                  }
              }
              answers.add(builder.toString());
              return;
          }
          return;
      }

      // 字符串用完，但是还没找到全部的IP地址，返回
      if (charIndex == s.length()) {
          return;
      }

      // 特殊情况，IP不能存在前导0，因此直接把0作为当前这个部分的地址
      if (s.charAt(charIndex) == '0') {
          segments[segIndex] = 0;
          dfs(s, segIndex + 1, charIndex + 1);
      }

      // 常规情况，依次尝试
      int address = 0;
      for (int charEnd = charIndex; charEnd < s.length(); charEnd++) {
          address = address * 10 + s.charAt(charEnd) - '0';
          if (address > 0 && address <= 255) {
              segments[segIndex] = address;
              dfs(s, segIndex + 1, charEnd + 1);
          } else {
              break;
          }
      }

  }

}