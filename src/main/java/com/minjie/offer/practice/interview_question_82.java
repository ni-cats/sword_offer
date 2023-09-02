package com.minjie.offer.practice;


import javafx.scene.control.TableView;

import java.nio.channels.NetworkChannel;
import java.nio.channels.NonReadableChannelException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 82: 包含重复元素的集合
 * @Version: 1.0
 */

public class interview_question_82 {
    public static void main(String[] args) {

        interview_question_82 testObject = new interview_question_82();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.combinationSum2(nums, 8);

    }

    private List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();

        helper(nums, target, 0, combination, result);
        return result;

    }

    private void helper(int[] nums, int target, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
        } else if (target > 0 && i < nums.length) {
            helper(nums, target, getIndex(nums, i), combination, result);

            combination.add(nums[i]);
            helper(nums, target - nums[i], i, combination, result);
            combination.removeLast();
        }
    }

    private int getIndex(int[] nums, int index) {
        int next = index;
        while (next < nums.length && nums[next] == nums[index]) {
            next++;
        }
        return next;

    }


}

