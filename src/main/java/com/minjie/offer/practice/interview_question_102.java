package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 102: 加减的目标值
 * @Version: 1.0
 */

public class interview_question_102 {
    public static void main(String[] args) {

        interview_question_102 testObject = new interview_question_102();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.findTargetSumWays(nums, 5));

    }

    //TODO 迭代
    private int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + S) % 2 == 1 || sum < S) {
            return 0;
        }
        return subsetSum(nums, (sum + S) / 2);
    }

    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }

}