package com.minjie.offer.practice;


import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 79: 所有子集
 * @Version: 1.0
 */

public class interview_question_79 {
    public static void main(String[] args) {

        interview_question_79 testObject = new interview_question_79();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.subsets(nums);

    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }
        helper(nums, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new LinkedList<>(subset));
        } else if (index < nums.length) {
            helper(nums, index + 1, subset, result);

            subset.add(nums[index]);
            helper(nums, index + 1, subset, result);
            subset.removeLast();
        }
    }


}

