package com.minjie.offer.practice;


import javafx.beans.binding.NumberExpressionBase;

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
 * @Description: TODO 105: 二分图
 * @Version: 1.0
 */

public class interview_question_106 {
    public static void main(String[] args) {

        interview_question_106 testObject = new interview_question_106();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] grid = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        System.out.println(testObject.isBipartite(grid));

    }

    //TODO
    private boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);
        for (int i = 0; i < size; i++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }


    //TODO 广度优先搜索
    private boolean setColor(int[][] graph, int[] colors, int i, int color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = color;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int neighbor : graph[v]) {
                if (colors[v] >= 0) {
                    if (colors[neighbor] == colors[v]) {
                        return false;
                    }
                } else {
                    queue.add(neighbor);
                    colors[neighbor] = 1 - colors[v];
                }
            }
        }
        return true;
    }


    //TODO 深度优先搜索 --- 基于栈
    private boolean setColor1(int[][] graph, int[] colors, int i, int color) {
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        colors[i] = color;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (int neighbor : graph[v]) {
                if (colors[v] >= 0) {
                    if (colors[neighbor] == colors[v]) {
                        return false;
                    }
                } else {
                    stack.push(neighbor);
                    colors[neighbor] = 1 - colors[v];
                }
            }
        }
        return true;
    }


    //TODO 深度优先搜索 --- 递归
    private boolean setColor2(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] >= 0) {
            return colors[i] == color;
        }
        colors[i] = color;
        for (int neighbor: graph[i]){
            if (!setColor2(graph,colors,neighbor,1-color)){
                return false;
            }
        }
        return true;
    }
}

