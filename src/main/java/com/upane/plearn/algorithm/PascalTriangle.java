package com.upane.plearn.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 杨辉三角形
 *
 * @Author:pan
 * @Date:2022/5/19
 */
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> generate = new Solution().generate(5);
        System.out.println(generate);

    }

    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; ++i) {
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0; j <= i; ++j) {
                    // 处理首位 设置为1
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        // 中间参数为相加之和
                        row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    }
                }
                ret.add(row);
            }
            return ret;
        }
    }
}
