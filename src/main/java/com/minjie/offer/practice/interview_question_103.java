package com.minjie.offer.practice;


import java.util.Arrays;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 103: 最少的硬币数目
 * @Version: 1.0
 */

public class interview_question_103 {
    public static void main(String[] args) {

        interview_question_103 testObject = new interview_question_103();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.coinChange(nums, 5));

    }

    //TODO 迭代并优化空间效率
    private int coinChange(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = target; j >= 1; j--) {
                for (int k = 0; k * coin <= j; k++) {
                    dp[j] = Math.min(dp[j], dp[j - k * coin] + k);
                }
            }

        }
        return dp[target] > target ? -1 : dp[target];
    }

    //TODO 新思路
    private int coinChange1(int[] coins, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i < target; i++) {
            dp[i] = target + 1;
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[target] > target ? -1 : dp[target];
    }

}