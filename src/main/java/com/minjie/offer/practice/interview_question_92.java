package com.minjie.offer.practice;


import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 92: 翻转字符
 * @Version: 1.0
 */

public class interview_question_92 {
    public static void main(String[] args) {

        interview_question_92 testObject = new interview_question_92();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.minFlipsMonoIncr(s));

    }

    private int minFlipsMonoIncr(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];
        char ch = s.charAt(0);
        dp[0][0] = ch == '0' ? 0 : 1;
        dp[1][0] = ch == '1' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            ch = s.charAt(i);
            dp[0][i % 2] = dp[0][(i - 1 % 2)] + ch == '0' ? 0 : 1;
            dp[1][i % 2] = Math.min(dp[0][(i - 1 % 2)], dp[1][(i - 1 % 2)]) + ch == '1' ? 0 : 1;
        }
        int last = s.length();
        return Math.min(dp[0][(last - 1) % 2], dp[1][(last - 1) % 2]);
    }


}