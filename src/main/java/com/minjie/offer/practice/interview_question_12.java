package com.minjie.offer.practice;

import java.util.HashMap;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题12：左右两边子数组的和相等
 * @Version: 1.0
 */

public class interview_question_12 {
    public static void main(String[] args) {

        interview_question_12 testObject = new interview_question_12();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.pivotIndex(testData));

    }

    private int pivotIndex(int[] nums) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (sum - nums[i] == total- sum){
                return i;
            }
        }
        return -1;
    }


}
