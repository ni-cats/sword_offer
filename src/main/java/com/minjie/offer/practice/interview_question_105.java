package com.minjie.offer.practice;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 105: 最大岛屿
 * @Version: 1.0
 */

public class interview_question_105 {
    public static void main(String[] args) {

        interview_question_105 testObject = new interview_question_105();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] grid = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.maxAreaOfIsland(grid));

    }

    //TODO
    private int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = getArea(grid, visited, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    //TODO 广度优先搜索
    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int area = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.remove();
            area++;

            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < grid.length
                        && c >= 0 && c < grid[0].length
                        && grid[r][c] == 1 && !visited[r][c]) {
                    queue.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }

    //TODO 深度优先搜索 --- 基于栈
    private int getArea1(int[][] grid, boolean[][] visited, int i, int j) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int area = 0;
        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            area++;
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < grid.length
                        && c >= 0 && c < grid[0].length
                        && grid[r][c] == 1 && !visited[r][c]) {
                    stack.push(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }

    //TODO 深度优先搜索 --- 递归
    private int getArea2(int[][] grid, boolean[][] visited, int i, int j) {
        int area = 1;
        visited[i][j] = true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < grid.length
                    && c >= 0 && c < grid[0].length
                    && grid[r][c] == 1 && !visited[r][c]) {
                area += getArea(grid, visited, r, c);
            }
        }
        return area;
    }
}

