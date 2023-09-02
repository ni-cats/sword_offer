package com.minjie.offer.practice;

import java.util.HashMap;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题10：和为k的最大子数组
 * @Version: 1.0
 */

public class interview_question_10 {
    public static void main(String[] args) {

        interview_question_10 testObject = new interview_question_10();
        int[] testData = new int[]{1,1,1};
        System.out.println(testObject.subarraySum(testData, 2));

    }

    private int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumToCount = new HashMap<>();
        //初始化操作？
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


}
