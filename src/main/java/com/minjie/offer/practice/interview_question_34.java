package com.minjie.offer.practice;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题34：外星语言是否排序
 * @Version: 1.0
 */

public class interview_question_34 {
    public static void main(String[] args) {

        interview_question_34 testObject = new interview_question_34();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        testObject.isAlienSorted(strs, s1);

    }

    private boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], orderArray)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(String word1, String word2, int[] order) {
        int i = 0;
        for (; i < word1.length() && i < word2.length(); i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if (order[ch1] < order[ch2]) {
                return true;
            }
            if (order[ch1] > order[ch2]) {
                return false;
            }
        }
        return i == word1.length();

    }


}


