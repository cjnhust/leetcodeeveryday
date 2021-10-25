class Solution {
    public String longestPalindrome(String s) {
        if(s ==null) return null;
        int len = s.length();
        if( len < 2) return s;
        int maxlen = 1;
        int begin = 0;
        // 序列型动态规划
        //  一 确定状态  dp[i][j] 是以i为开头 j为结尾的子串
        // 如果的dp[i][j]是回文子串 那么如果 s[i-1] == s[j+1] dp[i-1][j+1]也是回文子串
        // 二 转移方程
        // dp[i][j] =s[j]==s[j]? dp[i+1][j-1]:false;
        // 三 边界情况
        // j-i =1||j-i = 2  dp[i][j] = true
        // 四 计算顺序
        // 从左到右


        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(chars[i]!=chars[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<=2){ // 
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&(j-i+1>maxlen)){
                    maxlen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxlen);

    }
}