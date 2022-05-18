package com.upane.plearn.algorithm;

/**
 * Description: 1、移除元素
 *
 * 简单题重拳出击
 * 好奇原来数组没变 所以debug
 * 原来数组确实没变 题目要求返回left指针就完事
 * 快慢指针
 * @Author:pan
 * @Date:2022/5/18
 */
public class RemoveElement {

    public static void main(String[] args) {

        int i = new RemoveElement().removeElement(new int[]{1, 2, 3}, 3);
        System.out.println(i);
    }

    public int removeElement(int[] nums, int val) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;


    }
}
