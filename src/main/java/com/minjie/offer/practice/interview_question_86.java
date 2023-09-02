package com.minjie.offer.practice;


import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 86: 分割回文子字符串
 * @Version: 1.0
 */

public class interview_question_86 {
    public static void main(String[] args) {

        interview_question_86 testObject = new interview_question_86();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.partition("jiangminjie");

    }

    private List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        LinkedList<String> subStrings = new LinkedList<>();
        helper(s, 0, subStrings, result);
        return result;
    }

    private void helper(String str, int start, LinkedList<String> subStrings, List<List<String>> result) {
        if (start == str.length()) {
            result.add(new LinkedList<>(subStrings));
            return;
        }
        for (int i = start; i < str.length(); i++) {
            if (isPalindrome(str, start, i)) {
                subStrings.add(str.substring(start, i + 1));
                helper(str, i + 1, subStrings, result);
                subStrings.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;

    }


}

