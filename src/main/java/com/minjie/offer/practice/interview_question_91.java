package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 91: 粉刷房子
 * @Version: 1.0
 */

public class interview_question_91 {
    public static void main(String[] args) {

        interview_question_91 testObject = new interview_question_91();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        System.out.println(testObject.minCost(costs));

    }

    private int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[3][2];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = costs[0][i];
        }
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                int prev1 = dp[(j + 1) % 3][(i - 1) % 2];
                int prev2 = dp[(j + 2) % 3][(i - 1) % 2];
                dp[j][i] = Math.min(prev1, prev2) + costs[i][j];
            }
        }
        int last = costs.length;
        return Math.min(dp[0][last], Math.min(dp[1][last], dp[2][last]));
    }


}