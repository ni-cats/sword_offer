package com.minjie.offer.practice;


import org.omg.CORBA.DoubleHolder;

import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 111: 计算除法
 * @Version: 1.0
 */

public class interview_question_111 {
    public static void main(String[] args) {
        interview_question_111 testObject = new interview_question_111();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.calcEquation(new LinkedList<>(), new double[]{}, new LinkedList<>());

    }


    //TODO 深度优先搜索  --- 回溯法
    private double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                results[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, from, to, visited);
            }

        }
        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String> visited) {
        if (from.equals(to)) {
            return 1.0;
        }
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double nextValue = dfs(graph, next, to, visited);
                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }
        visited.remove(from);
        return -1.0;
    }

    // 创建树
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String val1 = equations.get(i).get(0);
            String val2 = equations.get(i).get(1);

            graph.putIfAbsent(val1, new HashMap<>());
            graph.get(val1).put(val2, values[i]);

            graph.putIfAbsent(val2, new HashMap<>());
            graph.get(val2).put(val1, 1.0 / values[i]);
        }
        return graph;
    }


}


