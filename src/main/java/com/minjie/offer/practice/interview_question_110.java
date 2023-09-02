package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 110: 所有路径
 * @Version: 1.0
 */

public class interview_question_110 {
    public static void main(String[] args) {

        interview_question_110 testObject = new interview_question_110();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.allPathsSourceTarget(matrix);

    }

    //TODO 深度优先搜索  --- 回溯法
    private List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, graph, path, result);
        return result;
    }

    private void dfs(int source, int[][] graph, LinkedList<Integer> path, List<List<Integer>> result) {
        path.add(source);
        if (source == graph.length - 1) {
            result.add(new LinkedList<>(path));
        } else {
            for (int next : graph[source]) {
                dfs(next, graph, path, result);
            }
        }
        path.removeLast();
    }


}


