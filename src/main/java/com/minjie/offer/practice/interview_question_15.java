package com.minjie.offer.practice;

import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题15：字符串中的所有变位词
 * @Version: 1.0
 */

public class interview_question_15 {
    public static void main(String[] args) {

        interview_question_15 testObject = new interview_question_15();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.checkInclusion("ac", "dgcaf"));

    }

    public List<Integer> checkInclusion(String s1, String s2) {
        LinkedList<Integer> indices = new LinkedList<>();

        if (s1.length() > s2.length()) {
            return indices;
        }

        int[] counts = new int[26];
        //初始化哈希表
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }

        if (allZeros(counts)) {
            indices.add(0);
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (allZeros(counts)) {
                indices.add(i - s1.length() + 1);
            }
        }

        return indices;
    }

    private boolean allZeros(int[] counts) {

        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}