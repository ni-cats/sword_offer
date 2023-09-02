package com.minjie.offer.practice;

import com.sun.javafx.robot.FXRobotImage;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题8：和大于或者等于k的最短子数组
 * @Version: 1.0
 */

public class interview_question_8 {
    public static void main(String[] args) {

        interview_question_8 testObject = new interview_question_8();
        int[] testData = new int[]{5, 1, 4, 3};
        System.out.println(testObject.minSubArrayLen(7, testData));

    }


    public int minSubArrayLen(int k, int[] nums) {

        int result = Integer.MAX_VALUE;
        int sum = 0;

        //定义两个指针
        int left = 0;
        int right = 0;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= k) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }

        return result;
    }
}
