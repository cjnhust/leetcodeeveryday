class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int left = 0;
        int max =0;
        int right = 0;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=right;j<s.length();j++){
                if(!list.contains(s.charAt(j))){
                    list.add(s.charAt(j));
                    right++;
                }else{
                    left++;
                    list.remove(0);
                    break;
                }
                max = Math.max(right-left,max);
            }
        }
        return max;
    }
}
