package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 97: 子序列的数目
 * @Version: 1.0
 */

public class interview_question_97 {
    public static void main(String[] args) {

        interview_question_97 testObject = new interview_question_97();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.numDistinct1("appplep", "apple"));

    }

    private int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    //TODO 优化空间效率
    private int numDistinct1(String s, String t) {
        int[] dp = new int[t.length() + 1];
        if (s.length() > 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.min(i,t.length()-1); j >=0 ; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}