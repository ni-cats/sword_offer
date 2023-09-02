package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题19：最多删除一个字符得到回文
 * @Version: 1.0
 */

public class interview_question_19 {
    public static void main(String[] args) {

        interview_question_19 testObject = new interview_question_19();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.validPalindrome("abca"));

    }

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (; start < s.length() / 2; ) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start == s.length() / 2
                || isPalindrome(s, start + 1, end)
                || isPalindrome(s, start, end - 1);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end;

    }
}