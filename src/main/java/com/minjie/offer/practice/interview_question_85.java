package com.minjie.offer.practice;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 85: 生成匹配括号
 * @Version: 1.0
 */

public class interview_question_85 {
    public static void main(String[] args) {

        interview_question_85 testObject = new interview_question_85();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.generateParenthesis(5);

    }

    private List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        helper(n, n, "", result);
        return result;
    }

    private void helper(int left, int right, String parenthesis, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(parenthesis);
            return;
        }
        if (left >= 0) {
            helper(left - 1, right, parenthesis + "(", result);
        }
        if (left < right) {
            helper(left, right - 1, parenthesis + ")", result);
        }
    }


}

