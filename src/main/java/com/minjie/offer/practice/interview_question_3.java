package com.minjie.offer.practice;

import java.sql.SQLOutput;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题3：前n个数字的二进制形式中1的个数
 * @Version: 1.0
 */

public class interview_question_3 {
    public static void main(String[] args) {

        interview_question_3 interviewQuestion3 = new interview_question_3();
        System.out.println(interviewQuestion3.countBits(5));
    }

    private int[] countBits(int num) {

        int[] result = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
          /*  int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
                System.out.println("------------j=" + j);
            }*/
            result[i] = result[i & (i - 1)] + 1;
        }
        for (int e : result) {
            System.out.println(e);
        }
        System.out.println(4 >> 1);
        return result;
    }


}
