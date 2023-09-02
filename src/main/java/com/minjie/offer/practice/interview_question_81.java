package com.minjie.offer.practice;


import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 81: 允许重复选择元素的组合
 * @Version: 1.0
 */

public class interview_question_81 {
    public static void main(String[] args) {

        interview_question_81 testObject = new interview_question_81();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.combination(nums, 8);

    }

    private List<List<Integer>> combination(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(nums, target, 0, combination, result);
        return result;
    }

    private void helper(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            helper(nums, target, i + 1, combination, result);

            combination.add(nums[i]);
            helper(nums, target - nums[i], i, combination, result);
            combination.removeLast();
        }

    }


}

