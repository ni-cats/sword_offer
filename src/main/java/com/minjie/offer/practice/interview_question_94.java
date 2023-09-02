package com.minjie.offer.practice;


import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 94: 最少的回文分割
 * @Version: 1.0
 */

public class interview_question_94 {
    public static void main(String[] args) {

        interview_question_94 testObject = new interview_question_94();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.minCut(s));

    }

    private int minCut(String s) {
        int len = s.length();
        boolean[][] isPal = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (ch1 == ch2 || (i <= j + 1 && isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                }
            }
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 0; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.max(dp[i], dp[j - 1] + 1);
                    }
                }
            }

        }
        return dp[len - 1];
    }


}