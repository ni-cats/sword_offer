package com.minjie.offer.practice;


import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 93: 最长斐波那契数列
 * @Version: 1.0
 */

public class interview_question_93 {
    public static void main(String[] args) {

        interview_question_93 testObject = new interview_question_93();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.lenLongestFibSubseq(nums));

    }

    private int lenLongestFibSubseq(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        int result = 2;
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                Integer k = map.getOrDefault(A[i] - A[j], -1);
                dp[i][j] = k > 0 && k < j ? dp[j][k] + 1 : 2;
                result = Math.max(result, dp[i][j]);
            }
        }
        return result > 2 ? result : 0;

    }


}