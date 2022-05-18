package com.upane.plearn.algorithm;

/**
 * Description:
 *
 * @Author:pan
 * @Date:2022/5/18
 */
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int maxConsecutiveOnes = new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1});
        System.out.println(maxConsecutiveOnes);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int temp = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i]==1){
                temp++;
            }else{
                temp=0;
            }
            if(temp>count){
                count=temp;
            }
        }
        return count;

    }

}
