class Solution {
    public int myAtoi(String s) {
        if(s==null||s.length()==0) return 0;
        int  res = 0;
        int sign = 1;
        int spaceNum = 0;
        boolean numStart = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ' && !numStart){
                spaceNum++;
                continue;
            }
            numStart = true;
            if(s.charAt(i)=='-'){
                if(i!=spaceNum) break;
                sign = sign*-1;
                continue;
            }
            if(s.charAt(i) == '+'){
                if(i!=spaceNum) break;
                sign = sign*1;
                continue;
            }
            if(s.charAt(i)>'9'||s.charAt(i)<'0'){
                break;
            }
            int nextInt = s.charAt(i)-'0';
            if(sign>0){
                if(res>(Integer.MAX_VALUE-nextInt)/10){
                    return Integer.MAX_VALUE;
                }
            }else if(-res<(Integer.MIN_VALUE+nextInt)/10){
                return Integer.MIN_VALUE;
            }
            res=res*10+nextInt;
        }
        return res*sign;

    }
}
