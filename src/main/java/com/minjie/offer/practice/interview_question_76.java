package com.minjie.offer.practice;


import com.oracle.webservices.internal.api.databinding.WSDLGenerator;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.awt.dnd.InvalidDnDOperationException;
import java.util.Random;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题76: 数组中第 k 大的数字
 * @Version: 1.0
 */

public class interview_question_76 {
    public static void main(String[] args) {

        interview_question_76 testObject = new interview_question_76();
        int[] nums = {1, 3, 6, 8};
        testObject.findKthLargest(nums, 3);

    }

    private int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);
        while (index != target) {
            if (index > target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
            index = partition(nums, left, right);
        }
        return nums[target];
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        int small = start - 1;
        swap(nums, random, end);
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 != index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}

