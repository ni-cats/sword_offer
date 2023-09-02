package com.minjie.offer.practice;


import com.sun.corba.se.impl.encoding.BufferManagerWriteCollect;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 96: 字符串交织
 * @Version: 1.0
 */

public class interview_question_96 {
    public static void main(String[] args) {

        interview_question_96 testObject = new interview_question_96();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.inInterleave("jiangminjie", "zhenghaiqing", "fengminjiongjun"));

    }

    private boolean inInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int i = 0; i < s2.length(); i++) {
            dp[0][i + 1] = s2.charAt(i) == s3.charAt(i) && dp[0][i];
        }
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                dp[i + 1][j + 1] = (ch1 == ch3 && dp[i][j + 1]) || (ch2 == ch3 && dp[i + 1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    //TODO 优化空间效率
    private boolean inInterleave1(String s1, String s2, String s3) {
        return false;
    }
}