package com.minjie.offer.practice;


import com.sun.javafx.robot.FXRobotImage;

import java.util.Arrays;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 99: 最小路径之和
 * @Version: 1.0
 */

public class interview_question_99 {
    public static void main(String[] args) {

        interview_question_99 testObject = new interview_question_99();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.minPathSum(costs));

    }

    //TODO 普通迭代法
    private int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    //TODO 普通迭代法  --- 优化
    private int minPathSum1(int[][] grid) {
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[0] = grid[i][0] + dp[0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = grid[i][j] + dp[j];
            }
        }
        return dp[grid[0].length - 1];
    }
}