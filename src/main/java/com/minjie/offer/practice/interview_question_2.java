package com.minjie.offer.practice;

import javax.print.attribute.standard.RequestingUserName;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题2：二进制加法
 * @Version: 1.0
 */

public class interview_question_2 {
    public static void main(String[] args) {

        interview_question_2 interviewQuestion2 = new interview_question_2();
        System.out.println(interviewQuestion2.addBinary("11", "10"));
    }

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); //result 保存计算结果

        //求出两个字符串长度
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; //保存进位，初始进位为0
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;  //sum 保存当前位的计算结果；

            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        //处理最后一位进位
        if (carry == 1) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

}
