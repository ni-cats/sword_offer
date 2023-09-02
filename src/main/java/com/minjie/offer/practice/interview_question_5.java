package com.minjie.offer.practice;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题5：单词长度的最大乘积
 * @Version: 1.0
 */

public class interview_question_5 {
    public static void main(String[] args) {

        interview_question_5 interviewQuestion3 = new interview_question_5();
        String[] strings = new String[]{"abcw", "foo", "bar", "fxyz", "abcdef"};
        System.out.println(interviewQuestion3.maxProduct2(strings));
    }

    public int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }
                if (k == 26) {
                    int pord = words[i].length() * words[j].length();
                    result = Math.max(result, pord);
                }
            }
        }
        return result;
    }

    // TODO 优化
    public int maxProduct2(String[] words) {

        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c :
                    words[i].toCharArray()) {
                flags[i] |= 1 << (c - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int pord = words[i].length() * words[j].length();
                    result = Math.max(result, pord);
                }
            }
        }


        return result;
    }

}
