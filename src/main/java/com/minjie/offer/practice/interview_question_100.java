package com.minjie.offer.practice;


import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 100: 三角形中最小路径之和
 * @Version: 1.0
 */

public class interview_question_100 {
    public static void main(String[] args) {

        interview_question_100 testObject = new interview_question_100();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] costs = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.minimumTotal(null));

    }

    //TODO 普通迭代法
    private int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size; j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (i > 0 && j == 0) {
                    dp[i][j] += dp[i - 1][j];
                } else if (i > 0 && i == j) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else if (i > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp[size - 1]) {
            min = Math.min(min, num);
        }
        return min;
    }


    //TODO 普通迭代法  --- 优化
    private int minimumTotal1(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (List<Integer> row : triangle) {
            for (int j = triangle.size()-1; j >=0; j--) {
                if (j == 0){
                    dp[j] +=row.get(j);
                }else if (j == row.size() - 1){
                    dp[j] = dp[j-1] + row.get(j);
                }else {
                    dp[j] = Math.min(dp[j],dp[j-1]) + row.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}