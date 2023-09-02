package com.minjie.offer.practice;


import sun.nio.cs.FastCharsetProvider;
import sun.plugin2.os.windows.FLASHWINFO;

import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 116: 朋友圈
 * @Version: 1.0
 */

public class interview_question_116 {
    public static void main(String[] args) {
        interview_question_116 testObject = new interview_question_116();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.findCircleNum(matrix);

    }

    //TODO 广度优先搜索
    private int findCircleNum(int[][] M) {

        boolean[] visited = new boolean[M.length];
        int result = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                findCircle(M, visited, i);
                result++;
            }
        }
        return result;
    }

    private void findCircle(int[][] M, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            Integer t = queue.remove();
            for (int friend = 0; friend < M.length; friend++) {
                if (M[t][friend] == 1 && !visited[friend]) {
                    queue.add(friend);
                    visited[friend] = true;
                }

            }
        }
    }

    //TODO 并查集
    private int findCircleNum1(int[][] M) {
        int[] fathers = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            fathers[i] = i;
        }
        int count = M.length;
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }
        return count;
    }

    private boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);
        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }

}


