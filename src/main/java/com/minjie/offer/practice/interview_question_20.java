package com.minjie.offer.practice;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题20：回文子字符串的个数
 * @Version: 1.0
 */

public class interview_question_20 {
    public static void main(String[] args) {

        interview_question_20 testObject = new interview_question_20();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.countSubStrings("abc"));

    }

    public int countSubStrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;

    }

    private int countPalindrome(String s, int start, int end) {

        int count = 0;
        while (start > 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;

        }
        return count;
    }
}