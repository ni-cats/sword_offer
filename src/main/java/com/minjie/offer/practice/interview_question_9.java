package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题9：乘积小于k的子数组
 * @Version: 1.0
 */

public class interview_question_9 {
    public static void main(String[] args) {

        interview_question_9 testObject = new interview_question_9();
        int[] testData = new int[]{10, 5, 2, 6};
        System.out.println(testObject.numSubbarrayProductLessThanK(testData, 100));

    }


    public int numSubbarrayProductLessThanK(int[] nums, int k) {

        int count = 0;
        int product = 1;

        //定义两个指针
        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left++];
            }
            count += left <= right ? right - left + 1 : 0;
        }

        return count;
    }
}
