package com.minjie.offer.practice;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 117: 相似的字符串
 * @Version: 1.0
 */

public class interview_question_117 {
    public static void main(String[] args) {
        interview_question_117 testObject = new interview_question_117();
        int[] nums = {2, 3, 4, 5, 3};
        int[][] matrix = {{2, 3, 4, 5, 3}, {2, 6}};
        ListNode[] root = {new ListNode(0)};
        String s = "jiangminjie";
        String[] strs = {"jiangminjie", "zhenghaiqing"};
        testObject.numSimilarGroups(strs);

    }


    //TODO 广度优先搜索

    //TODO 并查集
    private int numSimilarGroups(String[] A) {
        int[] fathers = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            fathers[i] = i;
        }
        int groups = A.length;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (simlar(A[i], A[j]) && union(fathers, i, j)) {
                    groups--;
                }
            }
        }
        return groups;
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


