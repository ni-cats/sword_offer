package com.minjie.offer.practice;


import javafx.scene.chart.NumberAxis;

import javax.sql.rowset.FilteredRowSet;
import java.awt.print.Book;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 101: 分割等和子集
 * @Version: 1.0
 */

public class interview_question_101 {
    public static void main(String[] args) {

        interview_question_101 testObject = new interview_question_101();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.canPartition(nums));

    }

    //TODO 递归
    private boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        return subsetSum(nums, sum / 2);
    }

    private boolean subsetSum(int[] nums, int target) {
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];
        return helper(nums, dp, nums.length, target);
    }

    private boolean helper(int[] nums, Boolean[][] dp, int i, int j) {
        if (dp[i][j] == null) {
            if (i == 0) {
                dp[i][j] = false;
            } else if (j == 0) {
                dp[i][j] = true;
            } else {
                dp[i][j] = helper(nums, dp, i - 1, j);
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = helper(nums, dp, i - 1, j - nums[i - 1]);
                }
            }
        }
        return dp[i][j];
    }
    //TODO 普通迭代法

    private boolean subsetSum1(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (!dp[i][j] && j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][target];
    }


    //TODO 普通迭代法  --- 优化
    private boolean subsetSum2(int[] nums, int target) {
        boolean[] dp = new boolean[target + 1];
            dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >=0 ; j--) {
                if (!dp[j] && j >= nums[i-1]){
                    dp[j] = dp[j-nums[i-1]];
                }
            }
        }
        return dp[target];
    }
}