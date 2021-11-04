class Solution {
    List<String> res = new ArrayList<>();
    int[] ip = new int[4];

    public List<String> restoreIpAddresses(String s) {
        if(s==null||s.length()==0) return res;
        ipReverseHelper(s,0,0);
        return res;
      

    }

    private void  ipReverseHelper(String s,int ipIndex,int charIndex){
        if(ipIndex == 4){
            StringBuffer buffer = new StringBuffer();
            for(int i=0;i<4;i++){
                buffer.append(ip[i]+"");
                if(i!=3){
                    buffer.append(".");
                }
            }
            if(charIndex == s.length()){
                res.add(buffer.toString());
            }
            return;
        }
        if(charIndex == s.length()){
            return;
        }

        if(s.charAt(charIndex) == '0'){
            ip[ipIndex] = 0;
            ipReverseHelper(s,ipIndex+1,charIndex+1);
        }

        int addR = 0;
        for(int i=charIndex;i<s.length();i++){
            addR = addR*10+s.charAt(i)-'0';
            if(addR>0&&addR<=255){
                ip[ipIndex] = addR;
                ipReverseHelper(s,ipIndex+1,i+1);
            }else{
                break;
            }
        }
    }
}
