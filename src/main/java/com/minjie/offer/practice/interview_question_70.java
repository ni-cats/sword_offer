package com.minjie.offer.practice;


import java.time.chrono.MinguoDate;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题70: 排序数组中只出现一次的数字
 * @Version: 1.0
 */

public class interview_question_70 {
    public static void main(String[] args) {

        interview_question_70 testObject = new interview_question_70();
        int[] nums = {1, 3, 6, 8};
        System.out.println(testObject.singleNonDuplicate(nums));

    }

    private int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid * 2;
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) {
                if (mid == 0 || nums[i - 2] == nums[i - 1]) {
                    return nums[i];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[nums.length - 1];
    }


}

