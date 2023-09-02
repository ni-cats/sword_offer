package com.minjie.offer.practice;

import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题16：不含重复字符的最长子字符串
 * @Version: 1.0
 */

public class interview_question_16 {
    public static void main(String[] args) {

        interview_question_16 testObject = new interview_question_16();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.lengthOfLongestSubString1("babcca"));

    }


    // TODO 解法一
    private int lengthOfLongestSubString(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int i = 0;
        int j = 0;
        int longest = 1;
        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            while (hasGreaterThan1(counts)) {
                counts[s.charAt(j)]--;
                j++;
            }
            longest = Math.max(longest, i - j + 1);

        }

        return longest;
    }

    private boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    // TODO 解法二
    private int lengthOfLongestSubString1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int i = 0;
        int j = 0;
        int longest = 1;
        int countDup = 0;
        for (; i < s.length(); i++) {
            counts[s.charAt(i)]++;
            if (counts[s.charAt(i)] == 2) {
                countDup++;
            }
            while (countDup > 0) {
                counts[s.charAt(j)]--;

                if (counts[s.charAt(j)] == 1) {
                    countDup--;
                }
                j++;
            }
            longest = Math.max(longest, i - j + 1);

        }

        return longest;

    }
}