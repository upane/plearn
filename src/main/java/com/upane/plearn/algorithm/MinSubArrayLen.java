package com.upane.plearn.algorithm;

/**
 * Description: 长度最小的子数组
 *
 * @Author:pan
 * @Date:2022/5/19
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int res = new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(res);
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;
            int sum = 0;
            int count = Integer.MAX_VALUE;
            while (right < nums.length) {
                sum += nums[right++];
                while (sum >= target) {
                    count = Math.min(count, right - left);
                    sum -= nums[left];
                    left++;
                }

            }
            return count == Integer.MAX_VALUE ? 0 : count;

        }
    }
}
