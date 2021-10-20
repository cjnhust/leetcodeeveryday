class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashSet<List<Integer>> data = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int target = -nums[i];
            list.remove(i);
            List<List<Integer>> result = twoNum(list, target);
            list.add(i,nums[i]);
            if(result.size()>0){
                data.addAll(result);
            }
        }
        return new ArrayList<List<Integer>>(data);

    }
    private List<List<Integer>> twoNum(List<Integer> nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        Set<List<Integer>> data = new HashSet<>();
        for(int i=0;i<nums.size();i++){
            map.put(nums.get(i), i);
        }
        for(int i=0;i<nums.size();i++){
            if(map.containsKey(target-nums.get(i)) && i!=(map.get(target-nums.get(i)))){
                List<Integer> result = new ArrayList<>();
                result.add(-target);
                result.add(nums.get(i));
                result.add(target-nums.get(i));
                Collections.sort(result);
                data.add(result);
            }
        }
        return new ArrayList<List<Integer>>(data);
    }
}
