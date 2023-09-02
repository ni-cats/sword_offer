package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题14：字符串中的变位词
 * @Version: 1.0
 */

public class interview_question_14 {
    public static void main(String[] args) {

        interview_question_14 testObject = new interview_question_14();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.checkInclusion("ac", "dgcaf"));

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] counts = new int[26];
        //初始化哈希表
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }

        if (allZeros(counts)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;
            if (allZeros(counts)) {
                return true;
            }
        }

        return false;
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