class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int sign = 1;
        int n = s.length();
        int i= 0;
        int res = 0;
        while(i<n){
            if(s.charAt(i)==' '){
                i++;
            }else if(s.charAt(i)=='+'){
                sign = 1;
                i++;
            }else if(s.charAt(i)=='-'){
                sign = -1;
                i++;
            }else if(s.charAt(i)=='('){
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
                i++;
            }else if(s.charAt(i)==')'){
                int curSign =  stack.pop();
                int beforeRes = stack.pop();
                res = res*curSign;
                res  = beforeRes+res;
                i++;
            }else{
                int num = 0;
                for(int k= i;k<n;k++){
                    if(Character.isDigit(s.charAt(i))){
                        num  = num*10+s.charAt(i)-'0';
                        i++;
                    }else{
                        break;
                    }
                }
                res += sign*num;
            }
        }
        return res;

    }
}