package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题69: 山峰数组的顶部
 * @Version: 1.0
 */

public class interview_question_69 {
    public static void main(String[] args) {

        interview_question_69 testObject = new interview_question_69();
        int[] nums = {1, 3, 6, 8};
        System.out.println(testObject.peakIndexInMountainArray(nums));

    }

    private int peakIndexInMountainArray(int[] nums) {

        int left = 1;
        int right = nums.length - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}

