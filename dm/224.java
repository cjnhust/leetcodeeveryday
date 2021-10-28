class Solution {
  public int calculate(String s) {
      int result = 0;
      
      Deque<Integer> stack = new LinkedList<Integer>();
      stack.push(1);

      int i = 0;
      int sign = 1;
      int length = s.length();
      while(i < s.length()) {
          if (s.charAt(i) == ' ') {
              i++;
          } else if (s.charAt(i) == '+') {
              sign = stack.peek();
               i++;
          } else if (s.charAt(i) == '-') {
              sign = -stack.peek();
               i++;
          } else if (s.charAt(i) == '(') {
              stack.push(sign);
               i++;
          } else if (s.charAt(i) == ')') {
              stack.pop();
               i++;
          } else {
              int num = 0;
              while(i < length && Character.isDigit(s.charAt(i))) {
                  num = num * 10 + (s.charAt(i) - '0');
                  i++;
              }
              result += num * sign;
          }
      }
      return result;
  }
}