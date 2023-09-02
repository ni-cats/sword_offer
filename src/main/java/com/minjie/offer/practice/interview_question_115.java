package com.minjie.offer.practice;


import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 115: 重建序列
 * @Version: 1.0
 */

public class interview_question_115 {
    public static void main(String[] args) {
        interview_question_115 testObject = new interview_question_115();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.sequenceReconstruction(nums, new LinkedList<LinkedList<Integer>>());

    }

    //TODO 深度优先搜索 --- 拓扑排序
    private boolean sequenceReconstruction(int[] org, LinkedList<LinkedList<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int num : seq) {
                if (num < 1 || num > org.length) {
                    return false;
                }
                graph.putIfAbsent(num, new LinkedList<>());
                inDegrees.putIfAbsent(num, 0);
            }

            for (int i = 0; i < seq.size() - 1; i++) {
                int num1 = seq.get(i);
                int num2 = seq.get(i + 1);
                if (!graph.get(num1).contains(num2)) {
                    graph.get(num1).add(num2);
                    inDegrees.put(num2, inDegrees.get(num2) + 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int num : inDegrees.keySet()) {
            if (inDegrees.get(num) == 0) {
                queue.offer(num);
            }
        }

        List<Integer> built = new LinkedList<>();
        while (queue.size() == 1) {
            int num = queue.remove();
            built.add(num);
            for (int next : graph.get(num)) {
                inDegrees.put(next, inDegrees.get(next) - 1);
                if (inDegrees.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        int[] result = new int[built.size()];
        result = built.stream().mapToInt(i -> i).toArray();
        return Arrays.equals(result, org);
    }


}


