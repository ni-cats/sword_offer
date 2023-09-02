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
 * @Description: TODO 面试题7：数组中和为0的三个数字
 * @Version: 1.0
 */

public class interview_question_7 {
    public static void main(String[] args) {

        interview_question_7 testObject = new interview_question_7();
        int[] testData = new int[]{1,2,4,6,10};
        for (List<Integer> i : testObject.threeSum(testData)) {
            System.out.println(i);
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length >= 3) {
            Arrays.sort(nums);

            int i = 0;
            while(i < nums.length - 2) {
                twoSum(nums, i, result);

                int temp = nums[i];
                while(i < nums.length && nums[i] == temp) {
                    ++i;
                }
            }
        }

        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                int temp = nums[j];
                while (nums[j] == temp && j < k) {
                    ++j;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            } else {
                --k;
            }
        }
    }


}
