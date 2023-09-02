package com.minjie.offer.cofrthoughts.chapter3;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Arrays;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer.cofrthoughts.chapter3.piece2
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-08-31  15:46
 * @Description: TODO 长度最小的子数组
 * @Version: 1.0
 */

public class Problem5 {
    public static void main(String[] args) {

        Problem5 testObject = new Problem5();
        int[] testData = new int[]{3, 2, 2, 2, 3};
        System.out.println(testObject.minSubArrayLen(9, testData));

    }

    //TODO 暴力解
    public int minSubArrayLen1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    result = Math.min(result, subLength);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //TODO 滑动窗口 --- 双指针
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
