package com.minjie.offer.practice;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题75: 数组相对排序
 * @Version: 1.0
 */

public class interview_question_75 {
    public static void main(String[] args) {

        interview_question_75 testObject = new interview_question_75();
        int[] nums1 = {1, 3, 6, 8};
        int[] nums2 = {1, 2, 3, 4};
        testObject.relativeSortArray(nums1, nums2);

    }

    private int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }

        int i = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        for (int num = 0; num < counts.length; num++) {
            while (counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        return arr1;
    }


}

