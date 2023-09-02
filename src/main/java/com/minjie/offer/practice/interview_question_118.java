package com.minjie.offer.practice;


import java.time.zone.ZoneOffsetTransitionRule;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 118: 多余的边
 * @Version: 1.0
 */

public class interview_question_118 {
    public static void main(String[] args) {
        interview_question_118 testObject = new interview_question_118();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.findRedundantConnection(matrix);

    }


    //TODO 广度优先搜索

    //TODO 并查集
    private int[] findRedundantConnection(int[][] edges) {

        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }

        int[] fathers = new int[maxVertex + 1];
        for (int i = 1; i <= maxVertex; i++) {
            fathers[i] = i;
        }
        for (int[] edge : edges) {
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
    }

    private boolean simlar(String str1, String str2) {
        int diffCount = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount <= 2;
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


