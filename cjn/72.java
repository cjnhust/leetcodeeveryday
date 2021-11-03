class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<word1.length()+1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<word2.length()+1;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<word1.length()+1;i++){
            for(int j=1;j<word2.length()+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = dp[i][j-1]+1; // 在word1插入一个s[j] 那么i不变 j向前移动
                    int delete = dp[i-1][j]+1; // 在word1 i位置删除 那么i向前移动 j不变等待匹配
                    int len = Math.min(insert,delete); 
                    int replace = dp[i-1][j-1]+1;// 在i,J位置替换 
                    len = Math.min(len,replace);
                    dp[i][j] = len;
                }

            }
        }
        return dp[word1.length()][word2.length()];
    }

    private int dp(int i,int j,String word1,String word2){
        if(i == -1 ) return j+1; // 第一个字符串到头了
        if(j == -1) return i+1;  // 第二个字符串到头了
        if(word1.charAt(i) == word2.charAt(j)) {
            return dp(i-1,j-1,word1,word2);
        }else{
            int insert = dp(i,j-1,word1,word2)+1; // 在word1插入一个s[j] 那么i不变 j向前移动
            int delete = dp(i-1,j,word1,word2)+1; // 在word1 i位置删除 那么i向前移动 j不变等待匹配
            int len = Math.min(insert,delete); 
            int replace = dp(i-1,j-1,word1,word2)+1;// 在i,J位置替换 
            len = Math.min(len,replace);
            return len;   
            // float len = Maht.min(Math.min(insert,delete),replace);

        }

    }
}
