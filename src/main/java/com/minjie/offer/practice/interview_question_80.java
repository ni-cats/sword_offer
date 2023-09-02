package com.minjie.offer.practice;


import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 80: 包含k个元素的组合
 * @Version: 1.0
 */

public class interview_question_80 {
    public static void main(String[] args) {

        interview_question_80 testObject = new interview_question_80();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.combine(5, 8);

    }

    private List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();

        helper(n, k, 1, combination, result);
        return result;
    }

    private void helper(int n, int k, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k) {
            result.add(new LinkedList<>(combination));
        } else if (i <= n) {
            helper(n,k,i+1,combination,result);

            combination.add(i);
            helper(n,k,i+1,combination,result);
            combination.removeLast();
        }
    }


}

