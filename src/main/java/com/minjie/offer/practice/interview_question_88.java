package com.minjie.offer.practice;


import com.sun.deploy.security.CPCallbackHandler;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 88: 爬楼梯的最小成本
 * @Version: 1.0
 */

public class interview_question_88 {
    public static void main(String[] args) {

        interview_question_88 testObject = new interview_question_88();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.minCostClimbingStairs(nums);

    }

    //TODO 递归代码
    private int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        return Math.min(helper(cost, len - 1), helper(cost, len - 2));
    }

    private int helper(int[] cost, int i) {
        if (i == 0 || i == 1) {
            return cost[i];
        }
        return Math.min(helper(cost, i - 1), helper(cost, i - 2)) + cost[i];

    }

    //TODO 递归代码
    private int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        helper(cost, len - 1, dp);
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    private void helper(int[] cost, int i, int[] dp) {
        if (i < 2) {
            dp[i] = cost[i];
        }
        if (dp[i] == 0) {
            helper(cost, i - 1, dp);
            helper(cost, i - 2, dp);
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
    }

    //TODO 迭代代码
    private int minCostClimbingStairs3(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

    //TODO 迭代代码  ---  优化
    private int minCostClimbingStairs4(int[] cost) {
        int len = cost.length;
        int[] dp = new int[]{cost[0],cost[1]};
        for (int i = 2; i < len; i++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }
}

