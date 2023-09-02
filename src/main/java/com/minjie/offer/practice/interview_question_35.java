package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题35：最小时间差
 * @Version: 1.0
 */

public class interview_question_35 {
    public static void main(String[] args) {

        interview_question_35 testObject = new interview_question_35();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        List<String> stringList = new ArrayList<>(Arrays.asList("00:00", "23:50"));
        testObject.findMinDifference(stringList);

    }

    private int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        boolean[] minuteFlags = new boolean[1440];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if (minuteFlags[min]) {
                return 0;
            }
            minuteFlags[min] = true;
        }
        return helper(minuteFlags);
    }

    private int helper(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;
        for (int i = 0; i < minuteFlags.length; i++) {
            if (minuteFlags[i]) {
                if (prev >= 0) {
                    minDiff = Math.min(i - prev, minDiff);
                }
            }
            prev = i;
            last = Math.max(last, i);
            first = Math.min(first, i);
        }
        return Math.min(first + minuteFlags.length - last, minDiff);
    }

}


