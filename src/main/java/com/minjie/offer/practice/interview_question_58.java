package com.minjie.offer.practice;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题58：日程表
 * @Version: 1.0
 */

public class interview_question_58 {
    public static void main(String[] args) {

        interview_question_58 testObject = new interview_question_58();
        System.out.println();
    }


}

class MyCalendar {
    private TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> event = events.floorEntry(start);
        if (event != null && event.getValue() > start) {
            return false;
        }
        event = events.ceilingEntry(start);
        if (event != null && event.getKey() < end) {
            return false;
        }
        events.put(start, end);
        return true;
    }
}