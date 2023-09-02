package com.minjie.offer.practice;

import java.util.Arrays;
import java.util.Random;


/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.practice
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-14  11:20
 * @Description: TODO
 * @Version: 1.0
 */

public class Sort {
    public static void main(String[] args) {
        System.out.println("排序算法");
    }

    //TODO 计数排序
    public int[] sortCount(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] counts = new int[max - min];
        for (int num : nums) {
            counts[num - min]++;
        }
        int i = 0;
        for (int num = min; num < max; num++) {
            if (counts[num - min] > 0) {
                nums[i++] = num;
                counts[num - min]--;
            }
        }
        return nums;
    }

    //TODO 快速排序
    public int[] sortQuick(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end > start) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int small = start - 1;
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

    //TODO 归并排序  -- 迭代法
    public int[] sortMerging(int[] nums) {
        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];
        for (int seg = 0; seg < length; seg += seg) {
            for (int start = 0; start < length; start += (seg * 2)) {
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg * 2, length);
                int i = start, j = mid, k = start;
                while (i < mid || j < end) {
                    if (j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] temp = src;
            src = dst;
            dst = temp;
        }
        return src;
    }

    //TODO 归并排序  -- 递归法
    public int[] sortMerging1(int[] nums) {
        int[] dst = new int[nums.length];
        dst = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, dst, 0, nums.length);
        return dst;
    }

    private void mergeSort(int[] src, int[] dst, int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(src, dst, start, mid);
        mergeSort(src, dst, mid, end);

        int i = start, j = mid, k = start;
        while (i < mid || j < end) {
            if (j == end || (i < mid && src[i] < src[j])) {
                dst[k++] = src[i++];
            } else {
                dst[k++] = src[j++];
            }
        }
    }

    //TODO 冒泡排序
    public int[] sortBubble(int[] nums) {
        return nums;
    }
}
