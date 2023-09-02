package com.minjie.offer.practice;

import java.util.HashMap;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题17：包含所有字符的最短字符串 --- hard
 * @Version: 1.0
 */

public class interview_question_17 {
    public static void main(String[] args) {

        interview_question_17 testObject = new interview_question_17();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.minWindow("ADDBANCAD", "ABC"));

    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }

        int count = charToCount.size();
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < s.length() || (count == 0 && end == s.length())) {
            //移动尾指针，加长字符串
            if (count > 0) {
                char endCh = s.charAt(end);
                if (charToCount.containsKey(endCh)) {
                    charToCount.put(endCh, charToCount.get(endCh) - 1);
                    if (charToCount.get(endCh) == 0) {
                        count--;
                    }
                }
                end++;
                //移动头指针，缩短字符串
            } else {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }
                char startCh = s.charAt(start);
                if (charToCount.containsKey(startCh)) {
                    charToCount.put(startCh, charToCount.get(startCh) + 1);
                    if (charToCount.get(startCh) == 1) {
                        count++;
                    }
                }
                start++;
            }
        }

        return minLength < Integer.MAX_VALUE ? s.substring(minStart, minEnd) : "";
    }
}