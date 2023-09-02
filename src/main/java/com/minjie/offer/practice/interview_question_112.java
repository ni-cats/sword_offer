package com.minjie.offer.practice;


import sun.util.resources.cldr.ak.CalendarData_ak_GH;

import java.util.*;
import java.util.function.LongBinaryOperator;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 112: 最长递增路径
 * @Version: 1.0
 */

public class interview_question_112 {
    public static void main(String[] args) {
        interview_question_112 testObject = new interview_question_112();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.longestIncreasingPath(matrix);

    }


    //TODO 深度优先搜索
    private int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] lengths = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int length = dfs(matrix, lengths, i, j);
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    private int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        if (lengths[i][j] != 0) {
            return lengths[i][j];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int length = 1;
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (r >= 0 && r < rows
                    && c >= 0 && c < cols
                    && matrix[i][j] < matrix[r][c]) {
                int path = dfs(matrix, lengths, i, j);
                length = Math.max(length, path + 1);
            }
        }
        lengths[i][j] = length;
        return length;
    }


}


