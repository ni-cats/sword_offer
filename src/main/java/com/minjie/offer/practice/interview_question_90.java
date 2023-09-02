package com.minjie.offer.practice;


import java.util.Arrays;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 90: 环形房屋偷盗
 * @Version: 1.0
 */

public class interview_question_90 {
    public static void main(String[] args) {

        interview_question_90 testObject = new interview_question_90();
        int[] nums = {2, 3, 4, 5, 3};
        ListNode[] root = {new ListNode(0)};
        System.out.println(testObject.rob(nums));

    }

    private int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result1 = helper(nums, 0, nums.length - 2);
        int result2 = helper(nums, 1, nums.length - 1);
        return Math.max(result1, result2);
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = nums[start];
        if (start < end) {
            dp[1] = Math.max(nums[start], nums[start + 1]);
        }
        for (int i = start + 2; i <= end; i++) {
            int j = i - start;
            dp[j % 2] = Math.max(nums[(j - 1) % 2], nums[(j - 2) % 2] + nums[j]);
        }
        return dp[(end - start) % 2];

    }


}