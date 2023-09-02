package com.minjie.offer.practice;


import com.sun.corba.se.spi.legacy.connection.LegacyServerSocketManager;

import java.util.function.DoublePredicate;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 95: 最长公共子序列
 * @Version: 1.0
 */

public class interview_question_95 {
    public static void main(String[] args) {

        interview_question_95 testObject = new interview_question_95();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String text1 = "jiangminjie";
        String text2 = "zhenghaiqing";
        System.out.println(testObject.longestCommonSubsequence(text1, text2));

    }

    //TODO 解法一:基于二维数组的迭代法
    private int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }


    //TODO 解法二:基于二维数组的迭代法   --- 优化
    private int longestCommonSubsequence1(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 > len2) {
            return longestCommonSubsequence1(text2, text1);
        }
        int[][] dp = new int[2][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[i % 2][j + 1], dp[(i + 1) % 2][j]);
                }
            }
        }
        return dp[len1 % 2][len2];
    }

    //TODO 解法二:基于二维数组的迭代法   --- 一维数组
    private int longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if (len1 > len2) {
            return longestCommonSubsequence2(text2, text1);
        }
        int[] dp = new int[len2 + 1];

        for (int i = 0; i < len1; i++) {
            int prev = dp[0];
            for (int j = 0; j < len2; j++) {
                int cur;
                if (text1.charAt(i) == text2.charAt(j)) {
                    cur = prev + 1;
                } else {
                    cur = Math.max(dp[j], dp[j + 1]);
                }
                prev = dp[j + 1];
                dp[j + 1] = cur;
            }
        }
        return dp[len2];
    }
}