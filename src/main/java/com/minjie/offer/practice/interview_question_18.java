package com.minjie.offer.practice;

import java.util.HashMap;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题18：有效的回文
 * @Version: 1.0
 */

public class interview_question_18 {
    public static void main(String[] args) {

        interview_question_18 testObject = new interview_question_18();
        int[] testData = new int[]{0, 1, 0};
        System.out.println(testObject.isPalindrome("Was it a cat I saw?"));

    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        while (i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!Character.isLetterOrDigit(ch1)){
                i++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                j--;
            }else {
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
                if (ch1 != ch2){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}