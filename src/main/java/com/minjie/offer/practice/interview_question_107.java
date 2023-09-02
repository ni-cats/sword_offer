package com.minjie.offer.practice;


import javax.naming.LinkRef;
import javax.swing.plaf.DimensionUIResource;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 107: 矩阵中的距离
 * @Version: 1.0
 */

public class interview_question_107 {
    public static void main(String[] args) {

        interview_question_107 testObject = new interview_question_107();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        testObject.updateMatrix(matrix);

    }


    //TODO 广度优先搜索
    private int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dists = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    dists[i][j] = 0;
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            int dist = dists[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < rows
                        && c >= 0 && c < cols) {
                    if (dists[r][c] > dist + 1) {
                        dists[r][c] = dist + 1;
                        queue.add(new int[]{r,c});
                    }
                }
            }
        }
        return dists;
    }


}

