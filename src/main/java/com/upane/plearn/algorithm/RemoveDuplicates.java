package com.upane.plearn.algorithm;

/**
 * Description:删除排序数组中的重复项
 * 快慢指针
 *
 * @Author:pan
 * @Date:2022/5/23
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[left] != nums[i]) {
                left++;
                nums[left] = nums[i];
            }
        }
        return left + 1;

    }
}
