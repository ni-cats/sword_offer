package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题73: 狒狒吃香蕉
 * @Version: 1.0
 */

public class interview_question_73 {
    public static void main(String[] args) {

        interview_question_73 testObject = new interview_question_73();
        int[] nums = {1, 3, 6, 8};
        testObject.minEatingSpeed(nums, 8);

    }

    private int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getHours(piles, mid) <= H) {
                if (mid == 1 || getHours(piles, mid - 1) > H) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int getHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }


}

