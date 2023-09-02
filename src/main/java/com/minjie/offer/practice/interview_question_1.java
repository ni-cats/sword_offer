package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题1：整数除法
 * @Version: 1.0
 */

public class interview_question_1 {
    public static void main(String[] args) {

        interview_question_1 interviewQuestion1 = new interview_question_1();
        int dividend = 15;
        int divisor = 2;
        System.out.println(interviewQuestion1.divide(15, 2));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int result = divideCore(dividend, divisor);

        return negative == 1 ? -result : result;


    }

    /**
     * @param dividend: 被除数
     * @param divisor:  除数
     * @return int
     * @throws
     * @Description TODO 对两个负数做除法
     * @author Ni_cats
     * @email Ni_cats@163.com
     * @date 2023/7/19 11:43
     */

    private int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int value = divisor;   // 存储除数
            int quotient = 1;       //存储每次循环的倍数
            while (value >= 0xc0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;

    }


}
