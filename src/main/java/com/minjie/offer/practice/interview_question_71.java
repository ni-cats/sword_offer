package com.minjie.offer.practice;


import com.sun.org.apache.regexp.internal.RE;

import java.util.Random;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题71: 按权重生成随机数
 * @Version: 1.0
 */

public class interview_question_71 {
    public static void main(String[] args) {

        interview_question_71 testObject = new interview_question_71();
        int[] nums = {1, 3, 6, 8};
        Solution solution = new Solution(nums);
        System.out.println(solution.pickIndex());

    }

    static class Solution {
        private int[] sums;
        private int total;

        public Solution(int[] w) {
            sums = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                total += w[i];
                sums[i] = total;
            }
        }

        public int pickIndex() {
            Random random = new Random();
            int p = random.nextInt(total);
            int left = 0;
            int right = sums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (sums[mid] > p) {
                    if (mid == 0 || sums[mid - 1] <= p) {
                        return mid;
                    }
                    right = mid - 1;
                }
                left = mid + 1;
            }
            return 0;
        }
    }

}

