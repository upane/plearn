package com.upane.plearn.algorithm;

/**
 * Description:寻找旋转排序数组中的最小值
 * 应该为二分法查找
 * 时间复杂度  log(n)
 *
 * @Author:pan
 * @Date:2022/5/23
 */
public class FindMin {


    public static void main(String[] args) {
        int[] ints = {4, 5, 1, 2, 3};
        int min = new FindMin().findMin(ints);
        System.out.println(min);


    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 这步有点会搞混 计算mid值
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }


    public int findMin2(int[] nums) {

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = nums[i] < min ? nums[i] : min;
        }
        return min;
    }
}
