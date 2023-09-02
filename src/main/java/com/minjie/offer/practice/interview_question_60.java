package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题60：出现频率最高的 k 个数字
 * @Version: 1.0
 */

public class interview_question_60 {
    public static void main(String[] args) {

        interview_question_60 testObject = new interview_question_60();
        TreeNode root = new TreeNode(0);
        int[] nums = {2, 1, 2, 3, 4, 5, 6, 4, 3};
        System.out.println(testObject.topKFrequent(nums, 3));

    }

    private List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue() - e2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }

        }
        List<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            result.add(entry.getKey());
        }
        return result;

    }


}
