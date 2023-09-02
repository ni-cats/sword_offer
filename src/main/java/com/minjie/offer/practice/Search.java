package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.practice
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-12  17:24
 * @Description: TODO 二分查找
 * @Version: 1.0
 */

public class Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
