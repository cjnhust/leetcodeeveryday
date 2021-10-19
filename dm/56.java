import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int[][] merge(int[][] intervals) {

        List<Bounds> intervalList = new ArrayList<>(intervals.length);

        for (int[] numArray : intervals) {
            intervalList.add(new Bounds(numArray[0], numArray[1]));
        }

        // 根据数组左边界升序排列
        intervalList.sort(new Comparator<Bounds>() {
            @Override
            public int compare(Bounds bounds1, Bounds bounds2) {
                return bounds1.left - bounds2.left;
            }
        });

        List<Bounds> outputList = new ArrayList<>(intervals.length);

        Bounds validBounds = new Bounds(intervalList.get(0).left, intervalList.get(0).right);
        for (int i = 0; i < intervalList.size(); i++) {
            Bounds currentBounds = intervalList.get(i);

            if (currentBounds.left <= validBounds.right) {
                validBounds.right = Math.max(currentBounds.right, validBounds.right);
            } else {
                outputList.add(new Bounds(validBounds));
                validBounds = currentBounds;
            }

            // 当前已是列表最后一项，天然地作为最后一个区间输出
            if (i == intervalList.size() - 1) {
                outputList.add(new Bounds(validBounds));
            }
        }

        int[][] outputArray = new int[outputList.size()][];
        for (int i = 0; i < outputList.size(); i++) {
            Bounds bounds = outputList.get(i);
            outputArray[i] = bounds.toArray();
        }

        return outputArray;
    }

    static class Bounds {
        public int left;
        public int right;

        public Bounds(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public Bounds(Bounds source) {
            this.left = source.left;
            this.right = source.right;
        }

        public int[] toArray() {
            return new int[]{ left, right };
        }
    }

}