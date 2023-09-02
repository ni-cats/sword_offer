package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题72: 求平方根
 * @Version: 1.0
 */

public class interview_question_72 {
    public static void main(String[] args) {

        interview_question_72 testObject = new interview_question_72();
        int[] nums = {1, 3, 6, 8};
        testObject.mySqrt(18);

    }

    private int mySqrt(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid <= n) {
                if ((mid + 1) * (mid + 1) > n) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }


}

