package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题57：值和下标之差都在给定的范围之内
 * @Version: 1.0
 */

public class interview_question_57 {
    public static void main(String[] args) {

        interview_question_57 testObject = new interview_question_57();
        TreeNode root = new TreeNode(0);
        int[] nums = {2, 1, 2, 3, 4, 5, 6, 4, 3};
        System.out.println(testObject.containsNearbyAlmostDuplicate(nums, 3, 2));

    }

    //TODO O(nlogk)
    private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Long lower = set.floor((long) nums[i]);
            if (lower != null && lower >= nums[i] - t) {
                return true;
            }
            Long upper = set.ceiling((long) nums[i]);
            if (upper != null && upper <= nums[i] - t) {
                return true;
            }

            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    //TODO O(n)
    private boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        HashMap<Integer, Integer> buckets = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBucketsID(num, bucketSize);
            if (buckets.containsKey(id)
                    || (buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num)
                    || (buckets.containsKey(id + 1) && buckets.get(id + 1) + t <= num)) {
                return true;
            }
            buckets.put(id, num);
            if (i >= k) {
                buckets.remove(getBucketsID(nums[i - k], bucketSize));
            }
        }
        return false;
    }

    private int getBucketsID(int num, int bucketSize) {
        return num >= 0 ? num / bucketSize : (num + 1) / (bucketSize - 1);
    }


}
