package com.minjie.offer.cofrthoughts.chapter3;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.cofrthoughts.chapter3.piece2
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-31  15:46
 * @Description: TODO 二分查找
 * @Version: 1.0
 */

public class Problem2 {
    public static void main(String[] args) {

        Problem2 testObject = new Problem2();
        int[] testData = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(testObject.search(testData, 9));

    }

    // TODO 递归
    private int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return binarySearch(left, right, nums, target);
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        if (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return binarySearch(left, mid - 1, nums, target);
            } else {
                return binarySearch(mid + 1, right, nums, target);
            }
        }
        return -1;
    }

    //TODO 非递归
    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
