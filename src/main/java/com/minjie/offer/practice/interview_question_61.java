package com.minjie.offer.practice;


import java.awt.font.NumericShaper;
import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题61：和最小的k个数对
 * @Version: 1.0
 */

public class interview_question_61 {
    public static void main(String[] args) {

        interview_question_61 testObject = new interview_question_61();
        TreeNode root = new TreeNode(0);
        int[] nums1 = {1, 2, 4, 5, 6,};
        int[] nums2 = {1, 3, 4, 6};
        System.out.println(testObject.kSmallestPairs(nums1, nums2, 3));

    }

    //TODO 基于最大堆实现
    private List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>(
                (p1, p2) -> (p2[0] + p2[1]) - (p1[0] + p1[1]));

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            for (int j = 0; j < Math.min(k, nums2.length); j++) {
                if (maxHeap.size() >= k) {
                    int[] root = maxHeap.peek();
                    if ((root[0] + root[1]) > (nums1[i] + nums2[j])) {
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i] + nums2[j]});
                    }
                } else {
                    maxHeap.offer(new int[]{nums1[i] + nums2[j]});
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            int[] poll = maxHeap.poll();
            result.add(Arrays.asList(poll[0], poll[1]));
        }
        return result;
    }

    //TODO 基于最大堆实现
    private List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>(
                (p1, p2) -> (nums1[p1[0]] + nums2[p1[1]]) - (nums1[p2[0] + nums2[p2[1]]]));
        if (nums2.length > 0) {
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            result.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));

            if (poll[1] < nums2.length - 1) {
                minHeap.offer(new int[]{poll[0], poll[1] + 1});
            }
        }

        return result;
    }
}
