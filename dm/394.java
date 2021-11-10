class Solution {
    
  private int pointerIndex = 0; // 当前的字符串索引

  public String decodeString(String s) {
      pointerIndex = 0;
      LinkedList<String> stack = new LinkedList<>();

      while(pointerIndex < s.length()) {
          char currentChar = s.charAt(pointerIndex);

          if (Character.isDigit(currentChar)) {
              String repeatNumStr = getRepeatNumStr(s);
              stack.addLast(repeatNumStr);
          } else if (Character.isLetter(currentChar) || '[' == currentChar) {
              stack.addLast(String.valueOf(currentChar));
              pointerIndex++;
          } else {
              pointerIndex++;

              LinkedList<String> tempList = new LinkedList<String>();
              while(!"[".equals(stack.peekLast())) {
                  tempList.addLast(stack.removeLast());
              }

              stack.removeLast(); // remove "["

              Collections.reverse(tempList);
              String tempStr = mapToString(tempList);
              int repeatNum = Integer.valueOf(stack.removeLast());
              
              StringBuffer repeatStrBuffer = new StringBuffer();
              for (int i = 0; i < repeatNum; i++) {
                  repeatStrBuffer.append(tempStr);
              }
              stack.addLast(repeatStrBuffer.toString());
          }
      }
      return mapToString(stack);
  }

  public String getRepeatNumStr(String s) {
      StringBuffer buffer = new StringBuffer();
      while(Character.isDigit(s.charAt(pointerIndex))) {
          buffer.append(s.charAt(pointerIndex));
          pointerIndex++;
      }
      return buffer.toString();
  }

  public String mapToString(LinkedList<String> list) {
      StringBuffer buffer = new StringBuffer();
      for (String s : list) {
          buffer.append(s);
      }
      return buffer.toString();
  }
}