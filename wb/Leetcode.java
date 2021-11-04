package com.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: Leetcode
 * @Description: //TODO
 * @Author: wangbin
 * @Date: 11/4/21
 */
public class Leetcode {

    // 符合ip规则的所有ip地址
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return total;
    }

    private List<String> total = new ArrayList<>();

    // 当前深度遍历的路径
    private Deque<String> path = new ArrayDeque<>();

    /**
     * @param beginIndex    当前可拆分的起始index
     * @param currentHeight - treeHeight
     */
    private void dfs(String source, int beginIndex, int currentHeight) {
        if (beginIndex == source.length()) {
            if (currentHeight == 4) {
                total.add(String.join(".", path));
            }
            return;
        }

        for (int i = beginIndex; i < beginIndex + 3; i++) {
            if (i >= source.length()) break;

            if ((4 - currentHeight) * 3 < source.length() - i) continue;

            boolean isNumber = judgeNumber(source, beginIndex, i);
            if (isNumber) {
                path.addLast(source.substring(beginIndex, i + 1));
                dfs(source, i + 1, currentHeight + 1);
                path.removeLast();
            }

        }


    }

    public boolean judgeNumber(String s, int left, int right) {
        int len = right - left + 1;
        //当前为0开头的且长度大于1的数字需要剪枝
        if (len > 1 && s.charAt(left) == '0')
            return false;
        //将当前截取的字符串转化成数字
        int res = len <= 0 ? 0 : Integer.parseInt(s.substring(left, right + 1));
        //判断截取到的数字是否符合
        return res >= 0 && res <= 255;
    }

}
