package com.minjie.offer.practice;


import java.util.*;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题41：滑动窗口的平均值
 * @Version: 1.0
 */

public class interview_question_41 {
    public static void main(String[] args) {

        interview_question_41 testObject = new interview_question_41();
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
//        System.out.println(testObject.MovingAverage(charsTest));

    }


}

class MovingAverage {
    private Queue<Integer> nums;
    private int capacity;
    private int sum;

    public MovingAverage(int size) {
        nums = new LinkedList<>();
        this.capacity = size;
    }

    public double next(int val) {
        nums.offer(val);
        sum += val;
        if (nums.size() > capacity) {
            sum -= nums.poll();
        }
        return (double) sum /nums.size();
    }

}
