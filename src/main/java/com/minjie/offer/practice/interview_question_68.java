package com.minjie.offer.practice;


import java.time.chrono.MinguoChronology;
import java.time.chrono.MinguoDate;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题68：查找插入位置
 * @Version: 1.0
 */

public class interview_question_68 {
    public static void main(String[] args) {

        interview_question_68 testObject = new interview_question_68();
        int[] nums = {1, 3, 6, 8};
        System.out.println(testObject.searchInsert(nums, 5));

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums.length;
    }


}

