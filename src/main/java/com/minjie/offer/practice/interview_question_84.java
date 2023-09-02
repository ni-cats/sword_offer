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
 * @Description: TODO 84: 包含重复元素集合的全排列
 * @Version: 1.0
 */

public class interview_question_84 {
    public static void main(String[] args) {

        interview_question_84 testObject = new interview_question_84();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.permute(nums);

    }

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        helper(nums, 0, result);
        return result;


    }

    private void helper(int[] nums, int i, List<List<Integer>> result) {
        if (i == nums.length) {
            LinkedList<Integer> permutation = new LinkedList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(permutation);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);

                    swap(nums, i, j);
                    helper(nums, i + 1, result);
                    swap(nums, i, j);
                }
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

