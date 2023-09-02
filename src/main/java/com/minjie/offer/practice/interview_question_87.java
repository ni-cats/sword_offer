package com.minjie.offer.practice;


import javax.swing.text.html.ListView;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 87: 恢复IP地址
 * @Version: 1.0
 */

public class interview_question_87 {
    public static void main(String[] args) {

        interview_question_87 testObject = new interview_question_87();
        int[] nums = {1, 3, 6, 8};
        ListNode[] root = {new ListNode(0)};
        testObject.restoreIpAddresses("jiangminjie");

    }

    private List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        helper(s, 0, 0, "", "", result);
        return result;
    }

    private void helper(String s, int i, int segI, String seg, String ip, List<String> result) {
        if (i == s.length() && segI == 3 && isValidSeg(seg)) {
            result.add(ip + seg);
        } else if (i < s.length() && segI <= 3) {
            char ch = s.charAt(i);
            if (isValidSeg(seg + ch)) {
                helper(s, i + 1, segI + 1, "" + ch, ip + seg + ".", result);
            }
            if (seg.length() > 0 && segI < 3) {
                helper(s, i + 1, segI + 1,""+ch,ip+seg+".",result );
            }
        }
    }

    private boolean isValidSeg(String seg) {
        return Integer.parseInt(seg) <=255 &&(seg.equals("0") || seg.charAt(0) != '0');
    }

}

