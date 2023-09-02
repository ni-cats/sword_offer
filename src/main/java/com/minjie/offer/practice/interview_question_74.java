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
 * @Description: TODO 面试题74: 合并区间
 * @Version: 1.0
 */

public class interview_question_74 {
    public static void main(String[] args) {

        interview_question_74 testObject = new interview_question_74();
        int[][] nums = {{1, 3, 6, 8}, {1, 2, 3, 4}};
        testObject.merge(nums);

    }

    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
        List<int[]> merged = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[]{intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j <intervals.length && intervals[j][0] < temp[1]){
                temp[1] = Math.max(temp[1],intervals[j][1]);
            }
            merged.add(temp);
            i = j;
        }
        int[][] result = new int[merged.size()][];
        return merged.toArray(result);
    }


}

