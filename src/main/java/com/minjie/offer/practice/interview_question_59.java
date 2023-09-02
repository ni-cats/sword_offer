package com.minjie.offer.practice;


import javax.xml.ws.soap.Addressing;
import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @BelongsProject: sword_offer
 * @BelongsPackage: com.minjie.offer
 * @Author: Ni_cats
 * @email: Ni_cats@163.com
 * @CreateTime: 2023-07-19  10:38
 * @Description: TODO 面试题59：数据流的第 k 大数字
 * @Version: 1.0
 */

public class interview_question_59 {
    public static void main(String[] args) {
        System.out.println();
    }

}


class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int size;

    public KthLargest(int k, int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < size) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}