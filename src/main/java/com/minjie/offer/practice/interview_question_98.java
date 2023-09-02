package com.minjie.offer.practice;


import java.util.Arrays;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 98: 路径的数目
 * @Version: 1.0
 */

public class interview_question_98 {
    public static void main(String[] args) {

        interview_question_98 testObject = new interview_question_98();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.uniquePaths(5, 2));

    }

    // TODO 递归
    private int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m - 1, n - 1, dp);

    }

    private int helper(int i, int j, int[][] dp) {
        if (dp[i][j] == 0) {
            if (i == 0 || j == 0) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = helper(i - 1, j, dp) + helper(i, j - 1, dp);
            }
        }
        return dp[i][j];
    }

    // TODO 迭代
    private int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    // TODO 迭代 --- 优化
    private int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] +=dp[j-1];
            }
        }
        return dp[n-1];
    }
}