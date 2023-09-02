package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题6：排序数组中的两个数字之和
 * @Version: 1.0
 */

public class interview_question_6 {
    public static void main(String[] args) {

        interview_question_6 testObject = new interview_question_6();
        int[] testData = new int[]{1,2,4,6,10};
        for (int i : testObject.twoSum(testData, 8)) {
            System.out.println(i);
        }

    }

    public int[] twoSum(int[] numbers,int target) {

        int i = 0;
        int j = numbers.length - 1;
        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i,j};
    }

}
