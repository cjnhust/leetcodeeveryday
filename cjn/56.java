class Solution {
    public int[][] merge(int[][] intervals) {
 if(intervals == null || intervals.length==0|| intervals[0].length==0){
            return intervals;
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            } 
        });
        List<int[]> result = new ArrayList<>();
        result.add(0, intervals[0]);
        // 1<2 3>2 3<6 1,6
        for(int i=1;i<intervals.length;i++){
                if(intervals[i][0]>result.get(result.size()-1)[1]){
                    result.add(result.size(), intervals[i]);
                }else{
                    int[] tmp = result.get(result.size()-1);
                    tmp[1] = Math.max(tmp[1], intervals[i][1]);
                    result.set(result.size()-1, tmp);
                }  
        }
        return result.toArray(new int[result.size()][2]);
    }
}
