class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> answerList = new ArrayList<>();

      Arrays.sort(nums);

      int length = nums.length;
      
      for (int i = 0; i < length; i++) {

          // 避免重复
          if (i > 0 && nums[i] == nums[i -1]) {
              continue;
          }

          int target = -nums[i];
          int rightPointer = length - 1; // 右指针

          for (int leftPointer = i + 1; leftPointer < length; leftPointer++) {

              // 避免重复
              if (leftPointer > i + 1 && nums[leftPointer] == nums[leftPointer - 1]) {
                  continue;
              }

              while(leftPointer < rightPointer && nums[leftPointer] + nums[rightPointer] > target) {
                  rightPointer--;
              }

              // 左右指针重复，直接退出本次循环
              if (leftPointer == rightPointer) {
                  break;
              }

              if (nums[leftPointer] + nums[rightPointer] == target) {
                  List<Integer> list = new ArrayList<Integer>();
                  list.add(nums[i]);
                  list.add(nums[leftPointer]);
                  list.add(nums[rightPointer]);
                  answerList.add(list);
              }

          }

      }
      
      return answerList;
  }

}