class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> list = new HashMap<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums1.length;
        int m = nums2.length;
        if(n>m){
            for(int i=0;i<m;i++){
                map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
            }
            for(int i=0;i<n;i++){
                if(map.containsKey(nums1[i])&&list.getOrDefault(nums1[i],0)<map.get(nums1[i])){
                    list.put(nums1[i],list.getOrDefault(nums1[i],0)+1);
                }
            }
            }else{
            for(int i=0;i<n;i++){
                map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
            }
            for(int i = 0;i<m;i++){
                if(map.containsKey(nums2[i])&&list.getOrDefault(nums2[i],0)<map.get(nums2[i])){
                    list.put(nums2[i],list.getOrDefault(nums2[i],0)+1);
                }
            }

        }
        List<Integer> data = new ArrayList<Integer>();
        for(Integer i:list.keySet()){
            for(int k = 0;k<list.get(i);k++){
                data.add(i);
            }
        }
         return data.stream().mapToInt(Integer::intValue).toArray();


    }
}