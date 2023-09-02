package com.minjie.offer.cofrthoughts.chapter3;

import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.cofrthoughts.chapter3.piece2
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-31  15:46
 * @Description: TODO 有序数组的平方
 * @Version: 1.0
 */

public class Problem4 {
    public static void main(String[] args) {

        Problem4 testObject = new Problem4();
        int[] testData = new int[]{3,2,2,2,3};
        System.out.println(testObject.sortedSquares(testData));

    }

    //TODO 暴力解
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    //TODO 双指针
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int index = nums.length-1;
        while (left <= right){
            if (nums[right]*nums[right] >= nums[left]* nums[left]){
                result[index] = nums[right] * nums[right];
                index--;
                right--;
            }else {
                result[index] = nums[left] * nums[left];
                index--;
                left++;
            }
        }
        return result;
    }


}
