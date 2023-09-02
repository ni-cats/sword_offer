package com.minjie.offer.practice;


import com.sun.webkit.graphics.WCImageFrame;

import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题42：最近请求次数
 * @Version: 1.0
 */

public class interview_question_42 {
    public static void main(String[] args) {

        interview_question_42 testObject = new interview_question_42();
        int[] testData = new int[]{0, 1, 0};
        ListNode head1 = new ListNode(520);
        ListNode head2 = new ListNode(520);
        String s1 = "anagram";
        String s2 = "nagaram";
        String[] strs1 = {"jiangminjie", "zhenghaiqing", "fengminjiongjun"};
        String[] strs = {"4", "13", "5", "/", "+"};
        int[] testInt = {3, 2, 5, 4, 6, 1, 4, 2};
        char[][] charsTest = new char[1][];
        List<String> stringList = new ArrayList<>(Arrays.asList("00:00", "23:50"));

    }


}

class RecentCounter {
    private Queue<Integer> times;
    private int windowSize;

    public RecentCounter() {
        times = new LinkedList<>();
        windowSize = 3000;
    }
    public int ping(int t){
        times.offer(t);
        while (times.peek() + windowSize < t){

            times.poll();
        }
        return times.size();
    }
}

