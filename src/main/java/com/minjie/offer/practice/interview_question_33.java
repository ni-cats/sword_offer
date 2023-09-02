package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题33：变位词组
 * @Version: 1.0
 */

public class interview_question_33 {
    public static void main(String[] args) {

        interview_question_33 testObject = new interview_question_33();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        testObject.groupAnagrams(strs);

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int[] hash = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        Map<Long, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long wordHash = 1;
            for (int i = 0; i < str.length(); i++) {
                wordHash *= hash[str.charAt(i) - 'a'];
            }
            groups.putIfAbsent(wordHash, new LinkedList<>());
            groups.get(wordHash).add(str);
        }
        return new LinkedList<>(groups.values());
    }

    // TODO 方法二
    private List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            groups.putIfAbsent(sorted, new LinkedList<>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }


}


