package com.minjie.offer.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题40：矩阵中的最大矩形
 * @Version: 1.0
 */

public class interview_question_40 {
    public static void main(String[] args) {

        interview_question_40 testObject = new interview_question_40();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs1 = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        String[] strs = {"4", "13", "5", "/", "+"};
        int[] testInt = {3, 2, 5, 4, 6, 1, 4, 2};
        char[][] charsTest = new char[1][];
        List<String> stringList = new ArrayList<>(Arrays.asList("00:00", "23:50"));
        System.out.println(testObject.maximalRectangle(charsTest));

    }

    private int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    //TODO 方法一：暴力法
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                maxArea = Math.max(maxArea, min * (j - i + 1));
            }
        }
        return maxArea;
    }

    //TODO 方法二：分治法
    private int largestRectangleArea2(int[] heights) {
        return helper(heights, 0, heights.length);
    }

    private int helper(int[] heights, int start, int end) {

        if (start == end) {
            return 0;
        }
        if (start + 1 == end)
            return heights[start];
        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[start] > heights[i]) {
                minIndex = i;
            }
        }
        int area = minIndex * (end - start + 1);
        int left = helper(heights, start, minIndex);
        int reight = helper(heights, minIndex, end);

        area = Math.max(area, left);
        return Math.max(area, reight);
    }

    //TODO 方法三：单调栈法
    private int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.pop() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }


}


