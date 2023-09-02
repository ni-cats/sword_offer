package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 119: 最长连续序列
 * @Version: 1.0
 */

public class interview_question_119 {
    public static void main(String[] args) {
        interview_question_119 testObject = new interview_question_119();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.longestConsecutive(nums);

    }

    //TODO 广度优先搜索
    private int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        while (!set.isEmpty()) {
            Iterator<Integer> iter = set.iterator();
            longest = Math.max(longest, bfs(set, iter.next()));
        }
        return longest;
    }

    private int bfs(Set<Integer> set, Integer num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        set.remove(num);
        int length = 1;
        while (!queue.isEmpty()) {
            Integer i = queue.remove();
            int[] neighbors = new int[]{i + 1, i - 1};
            for (int neighbor : neighbors) {
                if (set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.remove(neighbor);
                    length++;
                }
            }
        }
        return length;
    }


    //TODO 并查集
    private int longestConsecutive1(int[] nums) {
        Map<Integer, Integer> fathers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        Set<Integer> all = new HashSet<>();
        for (int num : nums) {
            fathers.put(num, num);
            counts.put(num, 1);
            all.add(num);
        }

        for (int num : nums) {
            if (all.contains(num + 1)) {
                union(fathers, counts, num, num + 1);
            }
            if (all.contains(num - 1)) {
                union(fathers, counts, num, num - 1);
            }
        }

        int longest = 0;
        for (int length : counts.values()) {
            longest = Math.max(longest, length);
        }
        return longest;
    }


    private void union(Map<Integer, Integer> fathers, Map<Integer, Integer> counts, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            fathers.put(fatherOfI, fatherOfJ);

            int countOfI = findFather(counts, i);
            int countOfJ = findFather(counts, j);
            counts.put(countOfJ, countOfI + countOfJ);
        }
    }

    private int findFather(Map<Integer, Integer> fathers, int i) {
        if (fathers.get(i) != i) {
            fathers.put(i, findFather(fathers, fathers.get(i)));
        }
        return fathers.get(i);
    }

}


