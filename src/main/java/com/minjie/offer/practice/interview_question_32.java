package com.minjie.offer.practice;

import java.util.HashMap;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题32：有效的变位词
 * @Version: 1.0
 */

public class interview_question_32 {
    public static void main(String[] args) {

        interview_question_32 testObject = new interview_question_32();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        testObject.isAnagram(s1, s2);

    }

    private boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] counts = new int[26];
        for (char ch : str1.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : str2.toCharArray()) {
            if (counts[ch - 'a'] == 0) {
                return false;
            }
            counts[ch - 'a']--;
        }
        return true;
    }

    // TODO 真正的哈希表实现
    public boolean isAnagram1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (!counts.containsKey(ch) || counts.get(ch) == 0) {
                return false;
            }
            counts.put(ch, counts.get(ch) - 1);
        }
        return true;
    }
}


