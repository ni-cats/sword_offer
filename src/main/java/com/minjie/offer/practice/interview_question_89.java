package com.minjie.offer.practice;


import java.util.Arrays;
import java.util.Deque;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 89: 房屋偷盗
 * @Version: 1.0
 */

public class interview_question_89 {
    public static void main(String[] args) {

        interview_question_89 testObject = new interview_question_89();
        int[] nums = {2, 3, 4, 5, 3};
        ListNode[] root = {new ListNode(0)};
        System.out.println(testObject.rob2(nums));

    }

    //TODO 递归代码
    private int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        return Math.max(helper(nums, len - 2), helper(nums, len - 3) + nums[len - 1]);
    }

    private int helper(int[] nums, int i) {
        if (i == 1) {
            return nums[0];
        } else if (i == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(helper(nums, i - 1), helper(nums, i - 2) + nums[i]);
    }


    //TODO 递归代码  --- 优化缓存
    private int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        helper(nums, len - 1, dp);
        return Math.max(dp[len - 1], dp[len - 2]);
    }

    private void helper(int[] nums, int i, int[] dp) {
        if (i == 0) {
            dp[i] = nums[0];
        } else if (i == 1) {
            dp[i] = Math.max(nums[0], nums[1]);
        } else if (dp[i] < 0) {
            helper(nums, i - 1, dp);
            helper(nums, i - 2, dp);
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
    }

    //TODO 迭代代码
    private int rob3(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        if (len > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    //TODO 迭代代码  ---  优化
    private int rob4(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = nums[0];
        if (len == 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < len; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
        }
        return dp[(len - 1) % 2];
    }

    //TODO 迭代代码  ---  优化  --- 两个状态方程
    private int rob5(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[0][i % 2] = Math.max(dp[0][(i - 1) % 2], dp[1][(i - 1) % 2]);
            dp[1][i % 2] = dp[0][(i - 1) % 2] + nums[i];
        }
        return Math.max(dp[0][(len - 1) % 2], dp[1][(len - 1) % 2]);
    }
}