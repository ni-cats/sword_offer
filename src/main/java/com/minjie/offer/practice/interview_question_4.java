package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题4：只出现一次的数字
 * @Version: 1.0
 */

public class interview_question_4 {
    public static void main(String[] args) {

        interview_question_4 interviewQuestion3 = new interview_question_4();
        int[] ints = new int[]{5, 5, 5, 2, 2,2, 9};
        System.out.println(interviewQuestion3.singleNumber(ints));
    }

    public int singleNumber(int[] nums) {
        int[] bitSums = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
        }

        return result;

    }



}
