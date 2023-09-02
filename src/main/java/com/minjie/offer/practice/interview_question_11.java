package com.minjie.offer.practice;

import java.util.HashMap;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题11：0和1个数相同的子数组
 * @Version: 1.0
 */

public class interview_question_11 {
    public static void main(String[] args) {

        interview_question_11 testObject = new interview_question_11();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.subarraySum(testData));

    }

    private int subarraySum(int[] nums) {
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        //初始化操作？
        sumToIndex.put(0, 1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return maxLength;
    }


}
